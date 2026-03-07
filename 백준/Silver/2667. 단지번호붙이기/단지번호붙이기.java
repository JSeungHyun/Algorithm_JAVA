import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        List<Integer> answer = new ArrayList<>();
        boolean[][] visitied = new boolean[N][N];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        // MAP 초기화
        for (int y=0; y<N; y++) {
            String[] line = br.readLine().split("");
            for (int x=0; x<N; x++) {
                map[y][x] = Integer.parseInt(line[x]);
            }
        }

        // 탐색
        Deque<int[]> queue = new ArrayDeque<>();
        for (int y=0; y<N; y++) {
            for (int x=0; x<N; x++) {
                if (visitied[y][x] || map[y][x] == 0) continue;
                int cnt = 0;
                queue.addLast(new int[]{y, x});
                visitied[y][x] = true;
                while (!queue.isEmpty()) {
                    int[] cur = queue.pollFirst();
                    cnt++;
                    for (int i=0; i<4; i++) {
                        int ny = cur[0] + dy[i];
                        int nx = cur[1] + dx[i];
                        
                        if (ny < 0 || ny >= N || nx < 0 || nx >= N || visitied[ny][nx]) continue;
                        visitied[ny][nx] = true;
                        if (map[ny][nx] == 0) continue;
                        queue.addLast(new int[]{ny, nx});
                    }
                }
                answer.add(cnt);
            }
        }

        // 정답 출력
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}