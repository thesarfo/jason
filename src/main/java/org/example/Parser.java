package org.example;

import java.util.List;

public class Parser {
    private List<String> tokens;
    private int current;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
        this.current = 0;
    }

    public boolean parse() {
        if (tokens.size() == 2 && tokens.get(0).equals("{") && tokens.get(1).equals("}")) {
            return true;
        }
        return false;
    }
}