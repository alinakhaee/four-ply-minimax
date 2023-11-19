package org.example;

import org.example.model.Game;
import org.example.model.Move;
import org.example.model.State;
import org.javatuples.Pair;

public class AlphaBeta {
    private static int numberOfSteps = 0;

    public static void minimaxSearch(Game game){
        Pair<Integer, Move> bestMove = maxValue(game, game.getInitialState(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("alpha-beta move utility: " + bestMove.getValue0());
        System.out.println("alpha-beta move : " + bestMove.getValue1());
        System.out.println("alpha-beta steps : " + numberOfSteps);
    }

    private static Pair<Integer, Move> maxValue(Game game, State state, int alpha, int beta){
        numberOfSteps++;
        if(game.isTerminal(state)){
            return new Pair<>(game.utility(state), null);
        }
        int v = Integer.MIN_VALUE;
        Move bestMove = null;
        int moveIndex = 1;
        for(Move move : game.getMoves(state)) {
            Pair<Integer, Move> valueMovePair = minValue(game, game.getStateAfterMove(move), alpha, beta);
            int v2 = valueMovePair.getValue0();
            if(v2 > v){
                v = v2;
                bestMove = new Move(state, move.getToState(), state.getStateName() + (moveIndex++));
                alpha = Math.max(alpha, v);
            }
            if(v >= beta){
                return Pair.with(v, bestMove);
            }
        }
        return new Pair<>(v, bestMove);
    }

    private static Pair<Integer, Move> minValue(Game game, State state, int alpha, int beta) {
        numberOfSteps++;
        if(game.isTerminal(state)){
            return new Pair<>(game.utility(state), null);
        }
        int v = Integer.MAX_VALUE;
        Move bestMove = null;
        int moveIndex = 1;
        for(Move move : game.getMoves(state)) {
            Pair<Integer, Move> valueMovePair = maxValue(game, game.getStateAfterMove(move), alpha, beta);
            int v2 = valueMovePair.getValue0();
            if(v2 < v){
                v = v2;
                bestMove = new Move(state, move.getToState(), state.getStateName() + (moveIndex++));
                beta = Math.min(beta, v);
            }
            if(v <= alpha){
                return Pair.with(v, bestMove);
            }
        }
        return new Pair<>(v, bestMove);
    }
}
