package com.bdd;

import com.characters.heroes.Hero;

import java.sql.*;

public class HeroDAO implements CRUD{

    Connection connection;
    Bdd database;

    /***CONSTRUCTORS***/
    public HeroDAO(){
        database = Bdd.getInstance();
        connection = database.getConnection();
    }

    /***METHODS***/
    public void create(Hero hero) {
        ResultSet result = null;
        String SQLRequest ="INSERT INTO heroes (Type, Name) VALUES(?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(SQLRequest);
            statement.setString(1, hero.getClass().getSimpleName());
            statement.setString(2, hero.getName());
            statement.executeUpdate();
            System.out.println("Votre héros a été sauvgardé.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Votre héros n'a pas pu être sauvegardé");
        }
    }

    public ResultSet getAll() throws SQLException {
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM heroes ;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet getById(int index) throws SQLException {
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM heroes WHERE Id=" + index + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
