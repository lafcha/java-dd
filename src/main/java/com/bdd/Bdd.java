package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class Bdd {

    /***ATTRIBUTES***/

      private Connection dbConnect;

    /***METHODS***/
    public Connection dbConnection() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           dbConnect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/DAndD","lafcha","lafcha");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return dbConnect;
    }

}
