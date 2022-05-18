package com.bdd;

import com.characters.heroes.Hero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface CRUD {

    public void create(Connection dbConnection, Hero hero);

    public ResultSet getAll(Connection dbConnection) throws SQLException ;

    public ResultSet getById(int index, Connection dbConnection) throws SQLException;

}
