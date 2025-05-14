import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            String reversed_s = new StringBuilder(s).reverse().toString();

            int sLength = s.length();
            int idx = 0;

            for (int j = 0; j <= s.length(); j++) {
                String suffix = s.substring(j);
                String prefix = reversed_s.substring(0, sLength - j);

                if (suffix.equals(prefix)) {
                    idx = j;
                    break;
                }
            }

            String extra = new StringBuilder(s.substring(0, idx)).reverse().toString();
            System.out.println(s + extra);
        }
    }
}