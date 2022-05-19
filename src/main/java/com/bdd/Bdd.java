package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bdd {

    /***ATTRIBUTES***/

      private static Bdd instance;

    /***METHODS***/
    private Bdd() {
        instance = null;
    }
    public static Bdd getInstance() {
        if ( instance == null ) {
            instance = new Bdd();
        }
        return instance;
    }
    public Connection getConnection(){
        Connection dbConnection = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DAndD","lafcha","lafcha");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return dbConnection;
    }
}
