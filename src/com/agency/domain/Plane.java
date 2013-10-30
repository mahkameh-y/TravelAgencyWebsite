package com.agency.domain;

import com.mysql.jdbc.ResultSet;

import java.sql.SQLException;
import java.util.Vector;
import java.util.Set;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: Mar 29, 2006
 * Time: 8:07:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Plane {
    private int id;
    private String number;
    private String model;
    private int capacity;
    private Set flights;

    public Plane(String number, String model, int capacity) {
        this.number = number;
        this.model = model;
        this.capacity = capacity;
    }

    /**
     * *************************constructors***************
     */


    public Plane() {
    }

    /**
     * *************************setter getter***************
     */


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set getFlights() {
        return flights;
    }

    public void setFlights(Set flights) {
        this.flights = flights;
    }

    /**
     * *************************database***************
     */
    public int save() {
        String query = "from Plane plane where plane.number='" + number + "' ";
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return 0;
        HibernateActions.save(this);
        return 1;
    }

    public  void delete() {
        HibernateActions.delete(this);
        deleteRelatives();
    }

    private void deleteRelatives() {
        String query = "from Flight flight" +
                " where flight.plane= "+ getId() +
                " or flight.plane is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Flight flight = (Flight) l.get(i);
            flight.delete();
        }
    }

    public static Vector<Plane> search(String number, String model, int capacity, int flightNumber) {
        Vector<Plane> results = new Vector<Plane>();
        boolean flag = false;
        String query;
        if (flightNumber > 0) {
            query = "SELECT plane FROM Plane plane LEFT JOIN plane.flights flights ";
            query += "WHERE flights.id = " + flightNumber + "  ";
            flag = true;
        } else
            query = "FROM Plane plane ";

        if (number != null && !number.equals("")) {
            if (!flag)
                query += " WHERE plane.number = '" + number + "'";
            else
                query += " AND plane.number = '" + number + "'";
            flag = true;
        }

        if (model != null && !model.equals("")) {
            if (!flag)
                query += "WHERE  plane.model = '" + model + "'";
            else
                query += " AND plane.model = '" + model + "'";
            flag = true;
        }

        if (capacity > 0) {
            if (!flag)
                query += "WHERE  plane.capacity = " + capacity + "";
            else
                query += " AND plane.capacity = " + capacity + "";
        }

        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Plane plane = (Plane) l.get(i);
            results.add(plane);
        }
        return results;
    }

    public  void update() {

        HibernateActions.update(this);
        updateRelatives();
    }

    private void updateRelatives() {
        String query = "from Flight flight" +
                " where flight.plane= "+ getId() +
                " or flight.plane is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Flight flight = (Flight) l.get(i);
            flight.setPlane(this);
            flight.update();
        }
    }

    

    public static Plane searchByID(int id) {

        Plane plane = new Plane();
        HibernateActions.load(plane, id);
        return plane;
    }

    public static Vector<Plane> getAllPlane() {
        Vector<Plane> result = new Vector<Plane>();
        List l = HibernateActions.query("from Plane p");
        for (int i = 0; i < l.size(); i++) {
            Plane plane = (Plane) l.get(i);
            result.add(plane);
        }
        return result;
    }

    public static Plane getFlightPlane(int flightID) {
        String query = "select plane from Plane plane left join plane.flights flights where ";
        query += "flights.id = " + flightID;
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return (Plane) l.get(0);
        return null;
    }
}
