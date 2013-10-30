package com.agency.struts.action;

import com.agency.domain.Passenger;
import com.agency.domain.Reservation;
import com.agency.domain.Flight;
import com.agency.struts.form.PassengerForm;
import com.agency.struts.form.ReservationForm;

import java.util.Vector;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 4:47:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationAction extends BaseAction {
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        ReservationForm reservationForm = (ReservationForm) form;


        //DELETE TRAVELLER
        if (reservationForm.getDeleteTraveller() != null) {
            if (super.isAllowed(request,"delete-traveller-flight")) {
                Integer[] passIntegers = reservationForm.getSelectedPassenger();
                int flightID = reservationForm.getFlightNumber().intValue();
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

        //DELETE FLIGHT
        else if (reservationForm.getDeleteFlight() != null) {
            if (super.isAllowed(request,"delete-flight-passenger")) {
                Integer[] selectedFlights = reservationForm.getSelectedFlights();
                int passengerID = reservationForm.getPassengerID().intValue();
                for (int i = 0; i < selectedFlights.length; i++) {
                    int selectedFlight = selectedFlights[i].intValue();
                    Reservation reservation = new Reservation(passengerID, selectedFlight);
                    reservation.delete();
                }
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }

        }

        //INSERT FLIGHT
        else if (reservationForm.getInsertFlight() != null) {
            if (super.isAllowed(request,"insert-flight-passenger")) {
                int passengerID = reservationForm.getPassengerID().intValue();
                int flightID = reservationForm.getFlight().intValue();
                Reservation reservation = new Reservation(passengerID, flightID);
                if (reservation.save() == 0)
                    request.setAttribute("error", "Error saving reservation");
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //SHOW FLIGHT LIST
        else if (reservationForm.getFlightNumber() != null) {
            if (super.isAllowed(request,"view-full-info-traveller-flight")) {
                int flightNumber = reservationForm.getFlightNumber().intValue();
                Vector<Passenger> passengers = Passenger.getFlightList(flightNumber);
                request.setAttribute("passengers", passengers);
                return mapping.findForward("passengerFrame");
            }
        }
        return mapping.findForward("forbidden");
    }
}
