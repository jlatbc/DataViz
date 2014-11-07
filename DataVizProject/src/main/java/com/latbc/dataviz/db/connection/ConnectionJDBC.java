package com.latbc.dataviz.db.connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.latbc.dataviz.beans.ConnectionBean;

/**
 *
 * @author Latbc
 */
public class ConnectionJDBC {

    public boolean getConnection(ConnectionBean connectionBean) {

        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return false;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

//        final String url ="jdbc:mysql://localhost:3306/person_db_test";
//        final String user="root";
//        final String password="";
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://" + connectionBean.getUrl(), connectionBean.getUser(), connectionBean.getPassword());
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
