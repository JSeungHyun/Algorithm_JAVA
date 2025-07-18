import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean flag;
        for (int i = 0; i < T; i++) {
            flag = false;
            Stack<Character> stack = new Stack<>();
            String parenthesis = br.readLine();
            for (int idx = 0; idx < parenthesis.length(); idx++) {
                char c = parenthesis.charAt(idx);
                if (c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!flag) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}