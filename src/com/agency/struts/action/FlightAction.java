//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.agency.struts.form.FlightForm;
import com.agency.domain.Flight;
import com.agency.domain.Plane;
import com.agency.domain.Reservation;
import com.agency.domain.Passenger;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;

/**
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * <p/>
 * XDoclet definition:
 *
 * @struts:action path="/insertFlight" name="insertFlightForm" input="/form/insertFlight.jsp" scope="request"
 */
public class FlightAction extends BaseAction {

    // --------------------------------------------------------- Instance Variables

    // --------------------------------------------------------- Methods

    /**
     * Method execute
     *
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
        FlightForm flightForm = (FlightForm) form;

        String number = flightForm.getNumber();
        int plane = 0;
        if (flightForm.getPlane() != null)
            plane = flightForm.getPlane().intValue();

        int capacity = 0;
        if (flightForm.getCapacity() != null)
            capacity = flightForm.getCapacity().intValue();

        int cost = 0;
        if (flightForm.getCost() != null)
            cost = flightForm.getCost().intValue();
        String source = flightForm.getSource();
        String destination = flightForm.getDestination();

        int year = 0;
        if (flightForm.getYear() != null)
            year = flightForm.getYear().intValue();

        int month = 0;
        if (flightForm.getMonth() != null)
            month = flightForm.getMonth().intValue();

        int day = 0;
        if (flightForm.getDay() != null)
            day = flightForm.getDay().intValue();
        Date date = null;
        if (day > 0 && month > 0 && year > 0)
            date = new Date(year, month, day);

        int hour = 0;
        if (flightForm.getHour() != null)
            hour = flightForm.getHour().intValue();

        int minute = 0;
        if (flightForm.getMinute() != null)
            minute = flightForm.getMinute().intValue();
        Time time = null;
        if (hour > 0 && minute >= 0)
            time = new Time(hour, minute, 0);

        Flight flight = new Flight(number, plane, date, capacity, cost, time, source, destination);

        //VIEW SAVE
        if (flightForm.getViewSave() != null) {
            if (super.isAllowed(request, "view-save-flight")) {
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                request.setAttribute("save", "save");
                return mapping.findForward("insertPage");
            }
        }

        //SAVE
        else if (flightForm.getSave() != null) {
            if (super.isAllowed(request, "insert-flight")) {
                if (flight.save() == 0)
                    request.setAttribute("error", "Error saving flight object");
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                request.setAttribute("save", "save");
                return mapping.findForward("insertPage");
            }
        }

        //VIEW SEARCH
        else if (flightForm.getViewSearch() != null) {
            if (super.isAllowed(request, "view-search-flight")) {
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //SEARCH
        else if (flightForm.getSearch() != null) {
            if (super.isAllowed(request, "search-flight")) {
                Vector<Flight> flights = Flight.search(number, plane, date, capacity, cost, time, source, destination, 0);
                request.setAttribute("flights", flights);
                return mapping.findForward("resultPage");
            }
        }

         //UPDATE
        else if (flightForm.getUpdate() != null) {
            if (super.isAllowed(request, "update-flight")) {
                int id = flightForm.getFlightNumber().intValue();
                Flight oldFlight = Flight.searchByID(id);
                flight.setNumber(oldFlight.getNumber());
                flight.setId(id);
                if (flight.update() == 0)
                    request.setAttribute("error", "Error updating flight object");
                request.setAttribute("flight", flight);
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                return mapping.findForward("flightFrame");
            }
        }

        //DELETE
        else if (flightForm.getDelete() != null) {
            if (super.isAllowed(request, "delete-flight")) {
                int id = flightForm.getFlightNumber().intValue();
                flight.setId(id);
                flight.delete();
                request.setAttribute("flight", flight);
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                return mapping.findForward("flightFrame");
            }
        }

        //DELETE TRAVELLER
        else if (flightForm.getDeleteTraveller() != null) {
            if (super.isAllowed(request, "delete-traveller-flight")) {
                Integer[] passIntegers = flightForm.getSelectedPassenger();
                int flightID = flightForm.getFlightNumber().intValue();
                for (int i = 0; i < passIntegers.length; i++) {
                    int passID = passIntegers[i].intValue();
                    Reservation reservation = new Reservation(passID, flightID);
                    reservation.delete();
                }
                Vector<Passenger> passengers = Passenger.getFlightList(flightID);
                request.setAttribute("passengers", passengers);
                return mapping.findForward("passengerFrame");
            }
        }



        //SHOW FULL INFO
        else if (flightForm.getFlightNumber() != null) {
            if (super.isAllowed(request, "view-full-info-flight")) {
                int id = flightForm.getFlightNumber().intValue();
                Flight result = Flight.searchByID(id);
                request.setAttribute("flight", result);
                Vector<Plane> planes = Plane.getAllPlane();
                request.setAttribute("planes", planes);
                return mapping.findForward("flightFrame");
            }
        }

        return mapping.findForward("forbidden");
    }

}