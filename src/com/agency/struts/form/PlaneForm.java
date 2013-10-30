//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * 
 * XDoclet definition:
 * @struts:form name="insertPlaneForm"
 */
public class PlaneForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
    private String model;
    private String number;
    private Integer capacity;
    private Integer flight;
    private String search;
    private String save;
    private String viewSearch;
    private String viewSave;
    private Integer planeID;
    private String update;
    private Integer[] selectedPlanes;
    private Integer flightNumber;
    private String updateFlightPlane;
    // --------------------------------------------------------- Methods

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
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

    public String getViewSave() {
        return viewSave;
    }

    public void setViewSave(String viewSave) {
        this.viewSave = viewSave;
    }

    public Integer getPlaneID() {
        return planeID;
    }

    public void setPlaneID(Integer planeID) {
        this.planeID = planeID;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public Integer[] getSelectedPlanes() {
        return selectedPlanes;
    }

    public void setSelectedPlanes(Integer[] selectedPlanes) {
        this.selectedPlanes = selectedPlanes;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getUpdateFlightPlane() {
        return updateFlightPlane;
    }

    public void setUpdateFlightPlane(String updateFlightPlane) {
        this.updateFlightPlane = updateFlightPlane;
    }
}