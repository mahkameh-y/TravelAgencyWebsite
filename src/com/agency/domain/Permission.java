package com.agency.domain;

import java.util.Vector;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 10:08:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Permission {
    private int id;
    private int role;
    private String actionURL;

    public Permission() {
    }

    public Permission(int role, String actionURL) {
        this.role = role;
        this.actionURL = actionURL;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getActionURL() {
        return actionURL;
    }

    public void setActionURL(String actionURL) {
        this.actionURL = actionURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Permission that = (Permission) o;

        if (role != that.role) return false;
        if (actionURL != null ? !actionURL.equalsIgnoreCase(that.actionURL) : that.actionURL != null) return false;

        return true;
    }

    public static Vector<Permission> getAllPermissions() {
        Vector<Permission> permissions = new Vector<Permission>();
        String query = "from Permission p";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Permission permission = (Permission) l.get(i);
            permissions.add(permission);
        }
        return permissions;
    }

}
