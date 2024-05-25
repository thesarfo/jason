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
                return true;  // Empty JSON object
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
                current++;
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
                if (parseValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean parseValue() {
        String token = tokens.get(current);
        if (token.startsWith("\"") || token.equals("true") || token.equals("false") || token.equals("null") || token.matches("\\d+(\\.\\d+)?")) {
            current++;
            return true;
        } else if (token.equals("{")) {
            return parse();
        } else if (token.equals("[")) {
            return parseArray();
        }
        return false;
    }

    private boolean parseArray() {
        current++;
        if (tokens.get(current).equals("]")) {
            current++;
            return true;
        } else {
            while (parseValue()) {
                if (tokens.get(current).equals(",")) {
                    current++;
                } else if (tokens.get(current).equals("]")) {
                    current++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
