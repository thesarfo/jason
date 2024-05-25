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
        if (tokens.get(current).equals("{")) {
            current++;
            if (tokens.get(current).equals("}")) {
                return true;
            } else {
                return parseMembers();
            }
        }
        return false;
    }

    private boolean parseMembers() {
        if (parsePair()) {
            while (tokens.get(current).equals(",")) {
                current++;
                if (!parsePair()) {
                    return false;
                }
            }
            if (tokens.get(current).equals("}")) {
                return true;
            }
        }
        return false;
    }

    private boolean parsePair() {
        if (tokens.get(current).startsWith("\"")) {
            current++;
            if (tokens.get(current).equals(":")) {
                current++;
                if (tokens.get(current).startsWith("\"")) {
                    current++;
                    return true;
                }
            }
        }
        return false;
    }
}
