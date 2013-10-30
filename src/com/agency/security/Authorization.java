package com.agency.security;

import com.agency.domain.Permission;
import com.agency.domain.Menu;
import com.agency.domain.MenuAccess;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: Mahkameh
 * Date: May 19, 2006
 * Time: 9:56:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Authorization {
    private static Vector<Permission> permissions ;
    private static Vector<Menu> menus;
    private static Vector<MenuAccess> menuAccess;
    static{
        permissions = Permission.getAllPermissions();
        menus = Menu.getAllMenus();
        menuAccess = MenuAccess.getAllMenuAccess();
    }

    public static boolean isAllowed(int role, String actionURL) {
        System.out.println("============actionURL = " + actionURL);
        Permission askedPermission = new Permission(role, actionURL);
        for (int i = 0; i < permissions.size(); i++) {
            Permission permission = permissions.elementAt(i);
            System.out.println("=======permission.getRole() = " + permission.getRole());
            System.out.println("========permission.action = " + permission.getActionURL());
            if (permission.equals(askedPermission))
                return true;
        }
        return false;
    }

    public static Vector<Permission> getAllowedZones(int role) {
        Vector<Permission> allowedPermissions = new Vector<Permission>();
        for (int i = 0; i < permissions.size(); i++) {
            Permission permission = permissions.elementAt(i);
            if (permission.getRole() == role) {
                allowedPermissions.add(permission);
                System.out.println("permission.getActionURL() = " + i + " : " +permission.getActionURL());
            }

        }
        return allowedPermissions;
    }

    public static Vector<Menu> getAllowedMenus(int role) {
         Vector<Menu> allowedMenus = new Vector<Menu>();
        for (int i = 0; i < menuAccess.size(); i++) {
            MenuAccess access = menuAccess.get(i);
            if (access.getRole() == role) {
                Menu menu = findMenu(access.getMenu().getId());
                allowedMenus.add(menu);
                System.out.println("menu.getUrl() = " + menu.getUrl());
            }
        }
        return allowedMenus;
    }

    private static Menu findMenu(int menuID) {
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.elementAt(i);
            if (menu.getId() == menuID)
                return menu;
        }
        return null;
    }
}
