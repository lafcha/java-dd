package com.bdd;

import com.characters.heroes.Hero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CRUD {

    public void create(Hero hero);

    public ResultSet getAll() throws SQLException ;

    public ResultSet getById(int index) throws SQLException;

}
