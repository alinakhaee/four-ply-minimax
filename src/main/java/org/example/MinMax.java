package org.example;

import org.example.model.Game;
import org.example.model.Move;
import org.example.model.State;
import org.javatuples.Pair;

public class MinMax {
    private static int numberOfSteps = 0;

    public static void minimaxSearch(Game game){
        Pair<Integer, Move> bestMove = maxValue(game, game.getInitialState());
        System.out.println("minimax move utility: " + bestMove.getValue0());
        System.out.println("minimax move : " + bestMove.getValue1());
        System.out.println("minimax steps : " + numberOfSteps);
    }

    private static Pair<Integer, Move> maxValue(Game game, State state){
        numberOfSteps++;
        if(game.isTerminal(state)){
            return new Pair<>(game.utility(state), null);
        }
        int v = Integer.MIN_VALUE;
        Move bestMove = null;
        int moveIndex = 1;
        for(Move move : game.getMoves(state)) {
            Pair<Integer, Move> valueMovePair = minValue(game, game.getStateAfterMove(move));
            int v2 = valueMovePair.getValue0();
            if(v2 > v){
                v = v2;
                bestMove = new Move(state, move.getToState(), state.getStateName() + (moveIndex++));
            }
        }
        return new Pair<>(v, bestMove);
    }

    private static Pair<Integer, Move> minValue(Game game, State state) {
        numberOfSteps++;
        if(game.isTerminal(state)){
            return new Pair<>(game.utility(state), null);
        }
        int v = Integer.MAX_VALUE;
        Move bestMove = null;
        int moveIndex = 1;
        for(Move move : game.getMoves(state)) {
            Pair<Integer, Move> valueMovePair = maxValue(game, game.getStateAfterMove(move));
            int v2 = valueMovePair.getValue0();
            if(v2 < v){
                v = v2;

                bestMove = new Move(state, move.getToState(), state.getStateName() + (moveIndex++));
            }
        }
        return new Pair<>(v, bestMove);
    }

}
