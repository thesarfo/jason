package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.example.Parser;
import org.example.Lexer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java App <file_path>");
            System.exit(1);
        }

        String filePath = args[0];
        try {
            String input = new String(Files.readAllBytes(Paths.get(filePath))).trim();

            Lexer lexer = new Lexer(input);
            List<String> tokens = lexer.tokenize();

            Parser parser = new Parser(tokens);
            if (parser.parse()) {
                System.out.println("Valid JSON");
                System.exit(0);
            } else {
                System.out.println("Invalid JSON");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
