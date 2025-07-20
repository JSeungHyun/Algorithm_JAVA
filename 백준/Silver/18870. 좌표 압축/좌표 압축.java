import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] original = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            original[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> compressed = new HashMap<>();
        int index = 0;
        for (int num : sorted) {
            if (!compressed.containsKey(num)) {
                compressed.put(num, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : original) {
            sb.append(compressed.get(num)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
