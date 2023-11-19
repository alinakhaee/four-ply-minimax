package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private final State initialState;
    private final List<Integer> utilities = new ArrayList<>();
    private final List<State> states = new ArrayList<>();

    public Game(){
        for(int i=0 ; i<81 ; i++){
            State leafState = new State(null, -20 + (int)(Math. random() * 41), "leaf"+(i+1));
//            State leafState = new State(null, i+1, "leaf"+(i+1));
            utilities.add(leafState.getUtility());
            states.add(leafState);
        }

        for(int i=0 ; i<27 ; i++){
            State state = new State(List.of(states.get(i*3), states.get(i*3+1), states.get(i*3+2)), null, "depth4"+(i+1));
            states.add(state);
        }


        for(int i=0 ; i<9 ; i++){
            State state = new State(List.of(states.get(i*3+81), states.get(i*3+82), states.get(i*3+83)), null, "depth3"+(i+1));
            states.add(state);
        }

        for(int i=0 ; i<3 ; i++){
            State state = new State(List.of(states.get(i*3+108), states.get(i*3+109), states.get(i*3+110)), null, "depth2"+(i+1));
            states.add(state);
        }

        initialState = new State(List.of(states.get(117), states.get(118), states.get(119)), null, "A");

        System.out.println(utilities);
    }

    public boolean isTerminal(State state){
        return state.getUtility() != null;
    }

    public int utility(State state) {
        return state.getUtility();
    }

    public ArrayList<Move> getMoves(State state) {
        ArrayList<Move> moves = new ArrayList<>();
        int moveIndex = 0;
        for(State childState : state.getChildStates()){
            Move move = new Move(state, childState, state.getStateName() + (moveIndex++));
            moves.add(move);
        }
        return moves;
    }

    public State getStateAfterMove(Move move) {
        return move.toState;
    }
}
