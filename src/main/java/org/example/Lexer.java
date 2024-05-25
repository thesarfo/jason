package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private String input;
    private int current;

    public Lexer(String input) {
        this.input = input;
        this.current = 0;
    }

    public List<String> tokenize() throws Exception {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"[^\"]*\"|[:,{}]");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String token = matcher.group();
            if (token.trim().isEmpty()) {
                continue;
            }
            tokens.add(token);
        }
        return tokens;
    }
}

