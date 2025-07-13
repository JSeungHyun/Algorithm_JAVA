import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minResult = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (minResult > value) minResult = value;
            if (maxResult < value) maxResult = value;
        }

        System.out.println(minResult + " " + maxResult);
    }
}