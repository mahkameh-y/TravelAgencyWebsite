//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.agency.struts.form.PassengerForm;
import com.agency.domain.Passenger;
import com.agency.domain.Flight;
import com.agency.domain.Reservation;

import java.util.Vector;

/**
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * 
 * XDoclet definition:
 * @struts:action path="/insertPassenger" name="insertPassengerForm" input="/form/insertPassenger.jsp" scope="request"
 */
public class PassengerAction extends BaseAction {

    // --------------------------------------------------------- Instance Variables

    // --------------------------------------------------------- Methods

    /**
     * Method execute
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) {
        PassengerForm passengerForm = (PassengerForm) form;

        String nationalCode = passengerForm.getNationalCode();
        String name = passengerForm.getName();
        String lastName = passengerForm.getLastName();
        String telephone = passengerForm.getTelephone();
        String address = passengerForm.getAddress();
        int flight = 0 ;
        if (passengerForm.getFlight() != null)
            flight = passengerForm.getFlight().intValue();
        String username = passengerForm.getUsername();
        String password = passengerForm.getPassword();
        Passenger passenger = new Passenger(nationalCode, name, lastName, telephone, address);

        //VIEW SAVE
        if (passengerForm.getViewSave() != null) {
            if (super.isAllowed(request,"view-save-passenger")) {
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("save", "save");
                return mapping.findForward("insertPage");
            }
        }

        //SAVE
        else if (passengerForm.getSave() != null) {
            if (super.isAllowed(request,"insert-passenger")) {
                if (passenger.save(flight, username, password) == 0)
                    request.setAttribute("error", "Error saving passenger object");
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("save", "save");
                return mapping.findForward("insertPage");
            }
        }

        //VIEW SEARCH
        else if (passengerForm.getViewSearch() != null) {
            if (super.isAllowed(request,"view-search-passenger")) {
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //SEARCH
        else if (passengerForm.getSearch() != null) {
            if (super.isAllowed(request,"search-passenger")) {
                Vector<Passenger> passengers = Passenger.search(nationalCode, name, lastName, telephone, address, flight);
                request.setAttribute("passengers", passengers);
                return mapping.findForward("resultPage");
            }
        }

        //DELETE
        else if (passengerForm.getDelete() != null) {
            if (super.isAllowed(request,"delete-passenger")) {
                Integer[] selectedPassengers = passengerForm.getSelectedPassenger();
                for (int i = 0; i < selectedPassengers.length; i++) {
                    int selectedPassenger = selectedPassengers[i].intValue();
                    Passenger pass = new Passenger();
                    pass.setId(selectedPassenger);
                    pass.delete();
                }
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //UPDATE
        else if (passengerForm.getUpdate() != null) {
            if (super.isAllowed(request,"update-passenger")) {
                int id = passengerForm.getPassengerID().intValue();
                passenger.setId(id);
                passenger.update();                    
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //VIEW FULL INFO
        else if (passengerForm.getPassengerID() != null) {
            if (super.isAllowed(request,"view-full-info-passenger")) {
                int id = passengerForm.getPassengerID().intValue();
                if (super.isAllowed(request,"view-full-info-passenger", id)) {
                    Passenger result = Passenger.searchByID(id);
                    request.setAttribute("passenger", result);
                    Vector<Flight> flights = Flight.getAllFlights();
                    request.setAttribute("flights", flights);
                    Vector<Flight> passengerFlights = result.getFlights();
                    request.setAttribute("passengerFlights", passengerFlights);
                    return mapping.findForward("fullInfoPage");
                }
            }
        }




        return mapping.findForward("forbidden");
    }

}