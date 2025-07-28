import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max_size = Math.max(X, K) * 2 + 1;
        int[] arr = new int[max_size];
        Arrays.fill(arr, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(X);
        arr[X] = 0;

        while (!deque.isEmpty()) {
            int num = deque.poll();
            if (num == K) {
                System.out.println(arr[num]);
                return;
            }
            if (num * 2 < max_size && arr[num * 2] == -1) {
                arr[num * 2] = arr[num];
                deque.addFirst(num * 2);
            }
            if (num > 0 && arr[num - 1] == -1) {
                arr[num - 1] = arr[num] + 1;
                deque.addLast(num - 1);
            }
            if (num + 1 < max_size && arr[num + 1] == -1) {
                arr[num + 1] = arr[num] + 1;
                deque.addLast(num + 1);
            }
        }

    }
}