//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.agency.struts.form.PlaneForm;
import com.agency.domain.Plane;
import com.agency.domain.Flight;

import java.util.Vector;

/**
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * <p/>
 * XDoclet definition:
 *
 * @struts:action path="/insertPlane" name="insertPlaneForm" input="/form/insertPlane.jsp" scope="request"
 */
public class PlaneAction extends BaseAction {

    // --------------------------------------------------------- Instance Variables

    // --------------------------------------------------------- Methods

    /**
     * Method execute
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return ActionForward
     */
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        PlaneForm planeForm = (PlaneForm) form;


        String model = planeForm.getModel();
        String number = planeForm.getNumber();
        int capacity = 0;
        if (planeForm.getCapacity() != null)
            capacity = planeForm.getCapacity().intValue();
        int flight = 0;
        if (planeForm.getFlight() != null)
            flight = planeForm.getFlight().intValue();
        Plane plane = new Plane(number, model, capacity);

        //VIEW SAVE
        if (planeForm.getViewSave() != null) {
            if (super.isAllowed(request, "view-save-plane")) {
                forwardPath = "insertPage";
                actionURL = "view-save-plane";
                return mapping.findForward("insertPage");
            }
        }

        //SAVE
        else if (planeForm.getSave() != null) {
            if (super.isAllowed(request, "insert-plane")) {
                if (plane.save() == 0)
                    request.setAttribute("error", "Error saving plane object");
                return mapping.findForward("insertPage");
            }
        }

        //VIEW SEARCH
        else if (planeForm.getViewSearch() != null) {
            if (super.isAllowed(request, "view-search-plane")) {
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //SEARCH
        else if (planeForm.getSearch() != null) {
            if (super.isAllowed(request, "search-plane")) {
                Vector<Plane> results = Plane.search(number, model, capacity, flight);
                request.setAttribute("planes", results);
                return mapping.findForward("resultPage");
            }
        }

        //UPDATE
        else if (planeForm.getUpdate() != null) {
            if (super.isAllowed(request, "update-plane")) {
                int id = planeForm.getPlaneID().intValue();
                plane.setId(id);
                plane.update();
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        //SHOW FLIGHT PLANE
        else if (planeForm.getFlightNumber() != null) {
            if (super.isAllowed(request, "view-full-info-plane-flight")) {
                int flightID = planeForm.getFlightNumber().intValue();
                Plane flightPlane = Plane.getFlightPlane(flightID);
                request.setAttribute("plane", flightPlane);
                return mapping.findForward("planeFrame");
            }
        }

        //UPDATE FLIGHT PLANE
        else if (planeForm.getUpdateFlightPlane() != null) {
            if (super.isAllowed(request, "update-plane-flight")) {
                int id = planeForm.getPlaneID().intValue();
                plane.setId(id);
                plane.update();

                request.setAttribute("plane", plane);
                return mapping.findForward("planeFrame");
            }
        }

        //REQUEST FULL INFO
        else if (planeForm.getPlaneID() != null) {
            if (super.isAllowed(request, "view-full-info-plane")) {
                int id = planeForm.getPlaneID().intValue();
                Plane result = Plane.searchByID(id);
                request.setAttribute("plane", result);
                return mapping.findForward("insertPage");
            }
        }

        //DELETE
        else if (planeForm.getSelectedPlanes() != null) {
            if (super.isAllowed(request, "delete-plane")) {
                Integer[] selectedPlanes = planeForm.getSelectedPlanes();
                for (int i = 0; i < selectedPlanes.length; i++) {
                    int selectedPlane = selectedPlanes[i].intValue();
                    plane.setId(selectedPlane);
                    plane.delete();
                }
                Vector<Flight> flights = Flight.getAllFlights();
                request.setAttribute("flights", flights);
                request.setAttribute("search", "search");
                return mapping.findForward("insertPage");
            }
        }

        request.getSession().invalidate();
        return mapping.findForward("forbidden");
    }

}