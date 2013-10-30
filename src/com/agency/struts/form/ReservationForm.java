package com.agency.struts.form;

import org.apache.struts.action.ActionForm;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 4:47:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationForm extends ActionForm {

    // --------------------------------------------------------- Instance Variables

    private Integer flightNumber;
    private Integer[] selectedPassenger;
    private String deleteTraveller;
    private Integer passengerID;
    private Integer[] selectedFlights;
    private String deleteFlight;
    private String insertFlight;
    private Integer flight;
    // --------------------------------------------------------- Methods

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer[] getSelectedPassenger() {
        return selectedPassenger;
    }

    public void setSelectedPassenger(Integer[] selectedPassenger) {
        this.selectedPassenger = selectedPassenger;
    }

    public String getDeleteTraveller() {
        return deleteTraveller;
    }

    public void setDeleteTraveller(String deleteTraveller) {
        this.deleteTraveller = deleteTraveller;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public Integer[] getSelectedFlights() {
        return selectedFlights;
    }

    public void setSelectedFlights(Integer[] selectedFlights) {
        this.selectedFlights = selectedFlights;
    }

    public String getDeleteFlight() {
        return deleteFlight;
    }

    public void setDeleteFlight(String deleteFlight) {
        this.deleteFlight = deleteFlight;
    }

    public String getInsertFlight() {
        return insertFlight;
    }

    public void setInsertFlight(String insertFlight) {
        this.insertFlight = insertFlight;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }
}
