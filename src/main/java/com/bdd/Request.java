package com.bdd;

import com.bdd.Bdd;
import com.characters.heroes.Hero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Request {

    /***ATTRIBUTES***/

    private String heroName;
    private String heroType;
    private Statement statement;
    private ResultSet result;


    /***CONSTRUCTORS***/

    /***METHODS***/

    public void saveHero(Bdd dbConnection, Hero hero) {
        //TODO

    }

    public ResultSet getAllHeroes(Connection dbConnection) throws SQLException {
        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery("SELECT * FROM heroes;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet getHeroById(int index, Connection dbConnection) throws SQLException {

        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery("SELECT * FROM heroes WHERE Id=" + index + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /***GETTERS***/

    /***SETTERS***/

}
