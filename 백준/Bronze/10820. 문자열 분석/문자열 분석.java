import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int lower = 0;
        int upper = 0;
        int digit = 0;
        int space = 0;
        while ((line = br.readLine()) != null) {
            lower = 0;
            upper = 0;
            digit = 0;
            space = 0;
            for (char c : line.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    upper++;
                } else if (Character.isLowerCase(c)) {
                    lower++;
                } else if (Character.isDigit(c)) {
                    digit++;
                } else if (c == ' ') {
                    space++;
                }
            }
            System.out.println(lower + " " + upper + " " + digit + " " + space);
        }
    }
}