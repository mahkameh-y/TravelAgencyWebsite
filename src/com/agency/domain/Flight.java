package com.agency.domain;

import com.mysql.jdbc.ResultSet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Vector;
import java.util.Set;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: Mar 29, 2006
 * Time: 8:22:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Flight {
    private int id;
    private String number;
    private Plane plane;
    private Date date;
    private int capacity;
    private long cost;
    private Time time;
    private String source;
    private String destination;
    private Set reservation;

    /**
     * *************************constructors***************
     */

    public Flight(String number, int planeID, Date date, int capacity, long cost, Time time, String source, String destination) {
        this.number = number;
        this.plane = new Plane();
        this.plane.setId(planeID);
        this.date = date;
        this.capacity = capacity;
        this.cost = cost;
        this.time = time;
        this.source = source;
        this.destination = destination;
    }

    public Flight() {

    }


    /**
     * *************************setter getter***************
     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Set getReservation() {
        return reservation;
    }

    public void setReservation(Set reservation) {
        this.reservation = reservation;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    /**
     * *************************database***************
     */
    public int save() {
        if (this.getPlane().getId() == 0)
            return 0;
        Plane plane = new Plane();
        HibernateActions.load(plane, this.getPlane().getId());
        if (plane.getCapacity() < this.capacity)
            return 0;
        String query = "from Flight flight where flight.number='" + this.number +"' ";
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return 0;
        HibernateActions.save(this);
        return 1;
    }

    public void delete() {
        HibernateActions.delete(this);
        deleteRelatives();
    }

    private void deleteRelatives() {
        String query = "from Reservation reservation" +
                " where reservation.flight= "+ getId() +
                " or reservation.flight is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Reservation reservation = (Reservation) l.get(i);
            reservation.deleteByID();
        }
    }

    public static Vector<Flight> search(String number, int planeID, Date date, int capacity, long cost, Time time, String source, String destination, int travellerID) {
        Vector<Flight> results = new Vector<Flight>();
        boolean flag = false;
        String query;
        if (travellerID > 0) {
            query = "SELECT flight FROM Flight flight LEFT JOIN flight.reservation reservation" +
                    " WHERE reservation.passenger = " + travellerID + " ";
            flag = true;
        } else
            query = "FROM Flight flight ";

        if (number != null && !number.equals("")) {
            if (!flag)
                query += " WHERE flight.number = '" + number + "'";
            else
                query += " AND flight.number = '" + number + "'";
            flag = true;
        }

        if (planeID > 0) {
            if (!flag)
                query += " WHERE flight.plane = '" + planeID + "'";
            else
                query += " AND flight.plane = '" + planeID + "'";
            flag = true;
        }

        if (date != null && !date.equals("")) {
            if (!flag)
                query += " WHERE flight.date = '" + date + "'";
            else
                query += " AND flight.date = '" + date + "'";
            flag = true;
        }


        if (capacity > 0) {
            if (!flag)
                query += " WHERE flight.capacity = " + capacity + "";
            else
                query += " AND flight.capacity = " + capacity + "";
        }

        if (cost > 0) {
            if (!flag)
                query += " WHERE flight.cost = " + cost + "";
            else
                query += " AND flight.cost = " + cost + "";
        }

        if (time != null && !time.equals("")) {
            if (!flag)
                query += " WHERE flight.time = '" + time + "'";
            else
                query += " AND flight.time = '" + time + "'";
            flag = true;
        }

        if (source != null && !source.equals("")) {
            if (!flag)
                query += " WHERE flight.source = '" + source + "'";
            else
                query += " AND flight.source = '" + source + "'";
            flag = true;
        }

        if (destination != null && !destination.equals("")) {
            if (!flag)
                query += " WHERE flight.destination = '" + destination + "'";
            else
                query += " AND flight.destination = '" + destination + "'";
        }

        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Flight flight = (Flight) l.get(i);
            results.add(flight);
        }
        return results;
    }

    public int update() {
        if (this.getPlane().getId() == 0)
            return 0;
        
        HibernateActions.update(this);
        updateRelatives();
        return 1;
    }

    private void updateRelatives() {
        String query = "from Reservation reservation" +
                " where reservation.flight= "+ getId() +
                " or reservation.flight is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Reservation reservation = (Reservation) l.get(i);
            reservation.setFlight(this);
            reservation.update();
        }
    }

    public static Flight searchByID(int id) {
        Flight flight = new Flight();
        HibernateActions.load(flight, id);
        return flight;
    }

    public static Vector<Flight> getAllFlights() {

        Vector<Flight> results = new Vector<Flight>();
        List l = HibernateActions.query("from Flight f");
        for (int i = 0; i < l.size(); i++) {
            Flight flight = (Flight) l.get(i);
            results.add(flight);
        }
        return results;
    }
}
