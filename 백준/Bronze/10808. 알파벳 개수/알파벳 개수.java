import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int[] result = new int[26];

        for (int i=0; i<words.length(); i++) {
            result[words.charAt(i) - 'a']++;
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}