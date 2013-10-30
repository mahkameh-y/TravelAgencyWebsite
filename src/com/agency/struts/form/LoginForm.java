package com.agency.struts.form;

import org.apache.struts.action.ActionForm;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 9:23:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends ActionForm {
    private String username;
    private String password;
    private String signUp;
    private String signIn;
    private String logoff;

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

    public String getSignUp() {
        return signUp;
    }

    public void setSignUp(String signUp) {
        this.signUp = signUp;
    }

    public String getSignIn() {
        return signIn;
    }

    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    public String getLogoff() {
        return logoff;
    }

    public void setLogoff(String logoff) {
        this.logoff = logoff;
    }
}
