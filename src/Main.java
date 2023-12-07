import model.Lexeme;
import model.LexicalAnalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> code = new HashMap<>();
        System.out.println("Enter set of words : ");
        String[] lines = new String[]{scanner.nextLine()};

        boolean lock = true; // To ignore multiple lines comments

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (!line.trim().startsWith("//") && lock && !line.trim().startsWith("/*"))
                code.put(i + 1, line);
            if (line.trim().startsWith("/*"))
                lock = false;
            if (line.trim().endsWith("*/"))
                lock = true;
        }
        List<Lexeme> lexemes = new LexicalAnalyzer().analyzeCode(code);

        for (Lexeme lexeme : lexemes) {
            System.out.println("Line : ");
            System.out.println(lexeme.getLine());
            System.out.println("value : ");
            System.out.println(lexeme.getValue());
            System.out.println("Token : ");
            System.out.println(lexeme.getToken());
            System.out.println("\n");
        }
    }}
