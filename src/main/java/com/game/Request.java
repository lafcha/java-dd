package com.game;

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


    /***GETTERS***/

    /***SETTERS***/

    /***METHODS***/

    public void saveHero(Bdd dbConnection, Hero hero) {
        //TODO

    }

    public ResultSet getAllHeroes(Connection dbConnection) throws SQLException {
        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery("SELECT * FROM heroes;");
            return result;

        } catch (SQLException e) {
            System.out.println("Erreur BDD");
        }
        return null;
    }

    public ResultSet getOneHero(int index, Connection dbConnection) throws SQLException {

        try {
            statement = dbConnection.createStatement();
            result = statement.executeQuery("SELECT ALL FROM Heroes WHERE ID = " + index + ";");
            return result;

        } catch (SQLException e) {

        }
        return null;
    }
}
