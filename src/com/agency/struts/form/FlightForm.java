//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * 
 * XDoclet definition:
 * @struts:form name="insertFlightForm"
 */
public class FlightForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
    private String number;
    private Integer plane;
    private Integer capacity;
    private Integer cost;
    private String source;
    private String destination;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private String save;
    private String viewSave;
    private String viewSearch;
    private String search;
    private Integer flightNumber;
    private String update;
    private String delete;
    private String deleteTraveller;
    private Integer[] selectedPassenger;

    // --------------------------------------------------------- Methods

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPlane() {
        return plane;
    }

    public void setPlane(Integer plane) {
        this.plane = plane;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getViewSave() {
        return viewSave;
    }

    public void setViewSave(String viewSave) {
        this.viewSave = viewSave;
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

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getDeleteTraveller() {
        return deleteTraveller;
    }

    public void setDeleteTraveller(String deleteTraveller) {
        this.deleteTraveller = deleteTraveller;
    }

    public Integer[] getSelectedPassenger() {
        return selectedPassenger;
    }

    public void setSelectedPassenger(Integer[] selectedPassenger) {
        this.selectedPassenger = selectedPassenger;
    }
}