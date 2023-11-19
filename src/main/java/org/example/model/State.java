package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class State {
    List<State> childStates;
    Integer utility; // null if it is not a leaf
    String stateName;
}
