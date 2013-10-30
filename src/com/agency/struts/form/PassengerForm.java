//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.form;

import org.apache.struts.action.ActionForm;

/**
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * <p/>
 * XDoclet definition:
 *
 * @struts:form name="insertPassengerForm"
 */
public class PassengerForm extends ActionForm {

    // --------------------------------------------------------- Instance Variables
    private String nationalCode;
    private String name;
    private String lastName;
    private String telephone;
    private String address;
    private Integer flight;
    private String viewSave;
    private String save;
    private String viewSearch;
    private String search;
    private String delete;
    private Integer passengerID;
    private String update;
    private Integer[] selectedPassenger;
    private Integer flightNumber;
    private String username;
    private String password;

    // --------------------------------------------------------- Methods

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public String getViewSave() {
        return viewSave;
    }

    public void setViewSave(String viewSave) {
        this.viewSave = viewSave;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getViewSearch() {
        return viewSearch;
    }

    public void setViewSearch(String viewSearch) {
        this.viewSearch = viewSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Integer[] getSelectedPassenger() {
        return selectedPassenger;
    }

    public void setSelectedPassenger(Integer[] selectedPassenger) {
        this.selectedPassenger = selectedPassenger;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
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
}