import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> stringSet = new HashSet<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stringSet.add(br.readLine());
        }

        List<String> list = stringSet.stream()
                .sorted((a, b) -> {
                    if (a.length() != b.length()) return a.length() - b.length();
                    return a.compareTo(b);
                })
                .collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }
    }
}