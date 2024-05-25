package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int current;

    public Lexer(String input) {
        this.input = input;
        this.current = 0;
    }

    public List<String> tokenize() throws Exception{
        List<String> tokens = new ArrayList<>();

        while (current < input.length()) {
            char ch = input.charAt(current);
            switch (ch) {
                case '{':
                    tokens.add("{");
                    current++;
                    break;
                case '}':
                    tokens.add("}");
                    current++;
                    break;
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    current++;
                    break;
                default:
                    throw new Exception("Unexpected character: " + ch);
            }
        }
        return tokens;
    }
}
