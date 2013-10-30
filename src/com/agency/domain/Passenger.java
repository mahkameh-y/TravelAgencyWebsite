/*
 * Created on Mar 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.agency.domain;

import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * @author Mahkameh
 *         <p/>
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class Passenger {

    private int id;
    private String nationalCode;
    private String name;
    private String lastName;
    private String telephone;
    private String address;
    private Set reservation;

    /********************constructors**************************/

    /**
     * @param nationalCode
     * @param name
     * @param lastName
     * @param telephone
     * @param address
     */
    public Passenger(String nationalCode, String name, String lastName,
                     String telephone, String address) {
        super();
        this.nationalCode = nationalCode;
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public Passenger() {

    }


    /**
     * *****************getter/setter*************************
     */

    public Set getReservation() {
        return reservation;
    }

    public void setReservation(Set reservation) {
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Returns the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the nationalCode.
     */
    public String getNationalCode() {
        return nationalCode;
    }

    /**
     * @param nationalCode The nationalCode to set.
     */
    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    /**
     * @return Returns the telephone.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone The telephone to set.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * *****************database *************************
     */
    public int save(int flightID, String username, String password) {
        if (flightID <= 0)
            return 0;
        String query = "from Passenger passenger where passenger.nationalCode='" + this.nationalCode +"' ";
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return 0;

        HibernateActions.save(this);
        Reservation reservation = new Reservation(this.id, flightID);
        Login login = new Login(username, password, 3, this.id);
        int error = login.save();
        if (error == 0)
            return 0;
        return reservation.save();
    }

    public void delete() {
        HibernateActions.delete(this);
        deleteRelatives();

    }

    private void deleteRelatives() {
        String query = "from Reservation reservation" +
                " where reservation.passenger= "+ getId() +
                " or reservation.passenger is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Reservation reservation = (Reservation) l.get(i);
            reservation.deleteByID();
        }

        query = "from Login login" +
                " where login.passengerID= "+ getId() +
                " or login.passengerID is null ";
        l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Login login = (Login) l.get(i);
            login.deletByID();
        }
    }

    public static Vector<Passenger> search(String nationalCode, String name, String lastName,
                                           String telephone, String address, int flightNumber) {
        Vector<Passenger> results = new Vector<Passenger>();
        boolean flag = false;
        String query;
        if (flightNumber > 0) {
            query = "SELECT passenger FROM Passenger passenger JOIN passenger.reservation reservation WHERE ";
            query += " reservation.flight = " + flightNumber + " ";
            flag = true;
        }
        else
            query = "FROM Passenger passenger ";

        if (nationalCode != null && !nationalCode.equals("")) {
            if (!flag)
                query += " WHERE passenger.nationalCode = '" + nationalCode + "'";
            else
                query += " AND passenger.nationalCode = '" + nationalCode + "'";
            flag = true;
        }

        if (name != null && !name.equals("")) {
            if (!flag)
                query += " WHERE passenger.name = '" + name + "'";
            else
                query += " AND passenger.name = '" + name + "'";
            flag = true;
        }

        if (lastName != null && !lastName.equals("")) {
            if (!flag)
                query += " WHERE passenger.lastName = '" + lastName + "'";
            else
                query += " AND passenger.lastName = '" + lastName + "'";
            flag = true;
        }

        if (telephone != null && !telephone.equals("")) {
            if (!flag)
                query += " WHERE passenger.telephone = '" + telephone + "'";
            else
                query += " AND passenger.telephone = '" + telephone + "'";
            flag = true;
        }

        if (address != null && !address.equals("")) {
            if (!flag)
                query += " WHERE passenger.address = '" + address + "'";
            else
                query += " AND passenger.address = '" + address + "'";
        }

        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Passenger passenger = (Passenger) l.get(i);
            results.add(passenger);
        }
        return results;
    }

    public void update() {
        
        HibernateActions.update(this);
        updateRelatives();
    }

    private void updateRelatives() {
        String query = "from Reservation reservation" +
                " where reservation.passenger= "+ getId() +
                " or reservation.passenger is null ";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Reservation reservation = (Reservation) l.get(i);
            reservation.setPassenger(this);
            reservation.update();
        }
    }



    public static Passenger searchByID(int id) {
        Passenger passenger = new Passenger();
        HibernateActions.load(passenger, id);
        return passenger;
    }

    public static Vector<Passenger> getFlightList(int flightID) {
        Vector<Passenger> results = new Vector<Passenger>();
        String query = "SELECT passenger from Passenger passenger left join passenger.reservation reservation WHERE ";
        query += "reservation.flight= " + flightID ;
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Passenger passenger = (Passenger) l.get(i);
            results.add(passenger);
        }
        return results;
    }

    public Vector<Flight> getFlights() {
        Vector<Flight> flights = new Vector<Flight>();
        String query = "select flight from Flight flight left join flight.reservation reservation where ";
        query += " reservation.passenger = " + this.id;
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Flight flight = (Flight) l.get(i);
            flights.add(flight);
        }
        return flights;
    }

}
