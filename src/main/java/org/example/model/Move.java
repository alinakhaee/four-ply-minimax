package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Move {
    State fromState;
    State toState;
    String moveName;

    @Override
    public String toString(){
        return this.moveName;
    }
}
