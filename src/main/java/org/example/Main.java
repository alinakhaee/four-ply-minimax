package org.example;

import org.example.model.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        MinMax.minimaxSearch(game);
        System.out.println();
        System.out.println();
        AlphaBeta.minimaxSearch(game);
    }
}