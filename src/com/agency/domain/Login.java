package com.agency.domain;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 9:38:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {
    private int id;
    private String username;
    private String password;
    private int role;
    private int passengerID;


    public Login(String username, String password, int role, int passengerID) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.passengerID = passengerID;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int save() {
        String query = "from Login login where login.username='" + username +"' ";
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return 0;
        HibernateActions.save(this);
        return 1;
    }

    public static Login search(String username, String hashPassword) {
        String query = "from Login login where login.username='" + username +"' and ";
        query += " login.password='" + hashPassword + "' ";
        List l = HibernateActions.query(query);
        if (l.size() > 0)
            return (Login) l.get(0);
        return null;
    }

    public void deletByID() {
        HibernateActions.delete(this);

    }
}
