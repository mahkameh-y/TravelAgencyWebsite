package com.agency.security;

import com.agency.domain.Login;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 9:34:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Authentication implements Roles{
    public static Login validate(String username, String password) {
        /*String newPassword = decodePassword(password);
        String hashPassword = hashMap(newPassword);*/
        String hashPassword = password;
        Login login = Login.search(username, hashPassword);
        return login;
    }

    private static String hashMap(String newPassword) {
        return newPassword;
    }

    private static String decodePassword(String password) {
        char[] passArray = password.toCharArray();
        char[] newPass = new char[passArray.length];
        for (int i = 0; i < passArray.length; i++) {
            char c = passArray[i];
            newPass[i] = (char) (c - i);
        }
        String newPassword = "";
        for (int i = 0; i < newPass.length; i++) {
            char newPas = newPass[i];
            newPassword += newPas;
        }
        return newPassword;
    }
}
