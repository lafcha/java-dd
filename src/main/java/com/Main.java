package com;

import com.game.Board;
import com.game.Game;

import java.sql.SQLException;

public class Main {

    private static final String database = "-d";

    public static void main(String[] args) throws SQLException {
        Boolean hasDatabase = false;

        if (args.length == 0) {
            hasDatabase = false;
        } else {
            String argDb = args[0];
            if (argDb.equals( "-db")) {
                hasDatabase = true;
            }
        }
        Game game = new Game(hasDatabase);
        game.start();
    }
}
