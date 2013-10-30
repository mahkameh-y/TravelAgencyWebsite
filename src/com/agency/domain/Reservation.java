package com.agency.domain;

import com.mysql.jdbc.ResultSet;

import java.sql.SQLException;
import java.util.Vector;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: Mar 29, 2006
 * Time: 8:46:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Reservation {

    private int id;
    private Passenger passenger;
    private Flight flight;

    public Reservation(int travellerID, int flightNumber) {
        this.passenger = new Passenger();
        this.passenger.setId(travellerID);
        this.flight = new Flight();
        this.flight.setId(flightNumber);

    }

    public Reservation() {
    }
    /*
    ********************setter getter********************
    */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * *****************database *************************
     */
    public int save() {
        if (passenger.getId() <= 0 || flight.getId() <= 0)
            return 0;
        String query = "from Reservation reservation ";
        query += " where reservation.flight= " + this.flight.getId();
        query += " and reservation.passenger = " + this.passenger.getId();
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return 0;
        HibernateActions.save(this);
        return 1;
    }

    public void delete() {
        String query = "from Reservation reservation ";
        query += " where reservation.flight= " + this.flight.getId();
        query += " and reservation.passenger = " + this.passenger.getId();
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Reservation reservation = (Reservation) l.get(i);
            HibernateActions.delete(reservation);
        }

    }

    public void deleteByID() {
        HibernateActions.delete(this);
    }

    public int update() {
        if (passenger.getId() <= 0 || flight.getId() <= 0)
            return 0;
        HibernateActions.update(this);
        return 1;
    }

}
