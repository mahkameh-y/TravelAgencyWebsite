package com.agency.struts.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agency.struts.form.LoginForm;
import com.agency.security.Authentication;
import com.agency.security.Roles;
import com.agency.security.Authorization;
import com.agency.domain.Login;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 9:23:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends Action implements Roles {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        LoginForm loginForm = (LoginForm) form;

        if (loginForm.getLogoff() != null) {
            request.getSession().setAttribute("role", null);
            request.getSession().setAttribute("allowedZones", null);
            request.getSession().setAttribute("allowedMenus", null);
            request.getSession().setAttribute("client", null);
            return mapping.findForward("error");
        }

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Login login = Authentication.validate(username, password);
        if (login == null) {
            System.out.println("invalid user or passs");
            return mapping.findForward("error");
        }
        System.out.println("==============login.getRole() in login action= " + login.getRole());
        request.getSession().setAttribute("role", new Integer(login.getRole()));
        request.getSession().setAttribute("allowedZones", Authorization.getAllowedZones(login.getRole()));
        request.getSession().setAttribute("allowedMenus", Authorization.getAllowedMenus(login.getRole()));
        request.getSession().setAttribute("client", new Integer(login.getPassengerID()));

        return mapping.findForward("welcome");

    }
}
