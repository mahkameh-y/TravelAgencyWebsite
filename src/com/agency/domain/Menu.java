package com.agency.domain;

import java.util.Vector;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 10:44:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {
    public static final int TOP_MENU = 1;
    public static final int RIGHT_MENU = 2;
    private int id;
    private String name;
    private String url;
    private String page;
    private int type;
    private Set access;

    public Menu() {
    }

    public Menu(String name, String url, String page, int type) {
        this.name = name;
        this.url = url;
        this.page = page;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Set getAccess() {
        return access;
    }

    public void setAccess(Set access) {
        this.access = access;
    }

    public static Vector<Menu> getAllMenus() {
        Vector<Menu> menus = new Vector<Menu>();
        String query = "from Menu menu";
        List l = HibernateActions.query(query);
        for (int i = 0; i < l.size(); i++) {
            Menu menu = (Menu) l.get(i);
            menus.add(menu);
        }
        return menus;
    }
}
