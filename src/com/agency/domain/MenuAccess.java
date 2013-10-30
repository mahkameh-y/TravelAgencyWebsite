package com.agency.domain;

import com.agency.domain.Menu;
import com.agency.domain.HibernateActions;

import java.util.Vector;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 10:49:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class MenuAccess {
    private int id;
    private int role;
    private Menu menu;

    public MenuAccess(int role, int menuID) {
        this.role = role;
        this.menu = new Menu();
        this.menu.setId(menuID);
    }

    public MenuAccess() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public static Vector<MenuAccess> getAllMenuAccess() {
        Vector<MenuAccess> accessList = new Vector<MenuAccess>();
        String query = "from MenuAccess accessList";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            MenuAccess menuAccess = (MenuAccess) l.get(i);
            accessList.add(menuAccess);
        }
        return accessList;
    }
}
