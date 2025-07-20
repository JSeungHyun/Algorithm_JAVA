import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        set.stream()
                .sorted((a, b) -> {
                    if (a.length() != b.length()) return a.length() - b.length();
                    else return a.compareTo(b);
                })
                .forEach(item -> System.out.println(item));
    }
}