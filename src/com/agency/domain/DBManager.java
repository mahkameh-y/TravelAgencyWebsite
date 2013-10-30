/*
 * Created on Mar 29, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.agency.domain;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * @author Mahkameh
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DBManager {
	public static Statement connectToDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.98.121/mahkameh_yaghmaie", "m.yaghmaie", "810181118");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root");
        return (Statement) connection.createStatement();
    }

    public static ResultSet executeSQLQuery(String query) throws SQLException {
        System.out.println("query = " + query);
        Statement statement = connectToDB();
        return (ResultSet) statement.executeQuery(query);
    }

    public static void updateSQLTable(String query) throws SQLException {
        System.out.println("query = " + query);
        Statement statement = connectToDB();
        statement.executeUpdate(query);
    }


}
