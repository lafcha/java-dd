package com;

import com.game.Board;
import com.game.Game;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Game game = new Game();
        game.start();
    }
}
