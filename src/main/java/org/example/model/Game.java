package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private final State initialState;
//    private final List<Integer> utilities = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27);
    private final List<Integer> utilities = new ArrayList<>();

    public Game(){
        for(int i=0 ; i<27 ; i++){
            utilities.add(-20 + (int)(Math. random() * 41));
        }

        System.out.println(utilities);

        State leaf1 = new State(4, Player.MIN_PLAYER, null, utilities.get(0), "leaf1");
        State leaf2 = new State(4, Player.MIN_PLAYER, null, utilities.get(1), "leaf2");
        State leaf3 = new State(4, Player.MIN_PLAYER, null, utilities.get(2), "leaf3");
        State leaf4 = new State(4, Player.MIN_PLAYER, null, utilities.get(3), "leaf4");
        State leaf5 = new State(4, Player.MIN_PLAYER, null, utilities.get(4), "leaf5");
        State leaf6 = new State(4, Player.MIN_PLAYER, null, utilities.get(5), "leaf6");
        State leaf7 = new State(4, Player.MIN_PLAYER, null, utilities.get(6), "leaf7");
        State leaf8 = new State(4, Player.MIN_PLAYER, null, utilities.get(7), "leaf8");
        State leaf9 = new State(4, Player.MIN_PLAYER, null, utilities.get(8), "leaf9");
        State leaf10 = new State(4, Player.MIN_PLAYER, null, utilities.get(9), "leaf10");
        State leaf11 = new State(4, Player.MIN_PLAYER, null, utilities.get(10), "leaf11");
        State leaf12 = new State(4, Player.MIN_PLAYER, null, utilities.get(11), "leaf12");
        State leaf13 = new State(4, Player.MIN_PLAYER, null, utilities.get(12), "leaf13");
        State leaf14 = new State(4, Player.MIN_PLAYER, null, utilities.get(13), "leaf14");
        State leaf15 = new State(4, Player.MIN_PLAYER, null, utilities.get(14), "leaf15");
        State leaf16 = new State(4, Player.MIN_PLAYER, null, utilities.get(15), "leaf16");
        State leaf17 = new State(4, Player.MIN_PLAYER, null, utilities.get(16), "leaf17");
        State leaf18 = new State(4, Player.MIN_PLAYER, null, utilities.get(17), "leaf18");
        State leaf19 = new State(4, Player.MIN_PLAYER, null, utilities.get(18), "leaf19");
        State leaf20 = new State(4, Player.MIN_PLAYER, null, utilities.get(19), "leaf20");
        State leaf21 = new State(4, Player.MIN_PLAYER, null, utilities.get(20), "leaf21");
        State leaf22 = new State(4, Player.MIN_PLAYER, null, utilities.get(21), "leaf22");
        State leaf23 = new State(4, Player.MIN_PLAYER, null, utilities.get(22), "leaf23");
        State leaf24 = new State(4, Player.MIN_PLAYER, null, utilities.get(23), "leaf24");
        State leaf25 = new State(4, Player.MIN_PLAYER, null, utilities.get(24), "leaf25");
        State leaf26 = new State(4, Player.MIN_PLAYER, null, utilities.get(25), "leaf26");
        State leaf27 = new State(4, Player.MIN_PLAYER, null, utilities.get(26), "leaf27");

        State e = new State(3, Player.MAX_PLAYER, List.of(leaf1, leaf2, leaf3), null, "E");
        State f = new State(3, Player.MAX_PLAYER, List.of(leaf4, leaf5, leaf6), null, "F");
        State g = new State(3, Player.MAX_PLAYER, List.of(leaf7, leaf8, leaf9), null, "G");
        State h = new State(3, Player.MAX_PLAYER, List.of(leaf10, leaf11, leaf12), null, "H");
        State i = new State(3, Player.MAX_PLAYER, List.of(leaf13, leaf14, leaf15), null, "I");
        State j = new State(3, Player.MAX_PLAYER, List.of(leaf16, leaf17, leaf18), null, "J");
        State k = new State(3, Player.MAX_PLAYER, List.of(leaf19, leaf20, leaf21), null, "K");
        State l = new State(3, Player.MAX_PLAYER, List.of(leaf22, leaf23, leaf24), null, "L");
        State m = new State(3, Player.MAX_PLAYER, List.of(leaf25, leaf26, leaf27), null, "M");

        State b = new State(2, Player.MIN_PLAYER, List.of(e, f, g), null, "B");
        State c = new State(2, Player.MIN_PLAYER, List.of(h, i, j), null, "C");
        State d = new State(2, Player.MIN_PLAYER, List.of(k, l, m), null, "D");

        initialState = new State(1, Player.MAX_PLAYER, List.of(b, c, d), null, "A");
    }

    public Player getPlayerToMove(State state){
        return state.getPlayer();
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
