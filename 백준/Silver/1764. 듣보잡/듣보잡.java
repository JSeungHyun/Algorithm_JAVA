import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> people = new HashSet<>();
        for (int i = 0; i < n; i++) {
            people.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (people.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}