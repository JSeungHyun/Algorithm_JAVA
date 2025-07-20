import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (".".equals(line)) {
                break;
            }
            sb.append(checkBalance(line)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static String checkBalance(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if ('(' == c || '[' == c) {
                stack.add(c);
            } else if (')' == c) {
                if (stack.isEmpty() || '(' != stack.pop()) {
                    return "no";
                }
            } else if (']' == c) {
                if (stack.isEmpty() || '[' != stack.pop()) {
                    return "no";
                }
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}