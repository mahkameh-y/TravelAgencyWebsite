//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_3.8.4/xslt/JavaClass.xsl

package com.agency.struts.action;

import com.agency.security.Authorization;
import com.agency.security.Roles;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;

/**
 * MyEclipse Struts
 * Creation date: 05-16-2006
 * <p/>
 * XDoclet definition:
 *
 * @struts:action path="/insertFlight" name="insertFlightForm" input="/form/insertFlight.jsp" scope="request"
 */
public class BaseAction extends Action implements Roles {

    // --------------------------------------------------------- Instance Variables
    public String forwardPath;
    public String actionURL;
    // --------------------------------------------------------- Methods
    public boolean isAllowed(HttpServletRequest request, String actionURL) {
        if (request.getSession() == null) {
            System.out.println("no session");
            return false;
        }
        if (request.getSession().getAttribute("role") == null) {
            System.out.println("no role");
            return false;
        }
        int role = ((Integer)request.getSession().getAttribute("role")).intValue();

        return Authorization.isAllowed(role, actionURL);
    }

    public boolean isAllowed(HttpServletRequest request, String actionURL, int passengerID) {

        int role = ((Integer)request.getSession().getAttribute("role")).intValue();
        if (role == passenger && actionURL.equalsIgnoreCase("view-full-info-passenger")) {
            int passID = 0;
            if (request.getSession().getAttribute("client") != null) {
                passID = ((Integer)request.getSession().getAttribute("client")).intValue();
                if (passID == passengerID)
                    return true;
            }
            return false;
        }
        return true;
    }

}