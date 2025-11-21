import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Character[][] graph = new Character[m][n];
        
        for (int i=0; i<board.length; i++) {
            String s = board[i];
            for (int j=0; j<s.length(); j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        
        do {
            boolean[][] visited = new boolean[m][n];
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int y = cur[0];
                int x = cur[1];
                if (visited[y][x]) continue;
                visited[y][x] = true;
                answer++;
                for (int ny=y; ny>0; ny--) graph[ny][x] = graph[ny-1][x];
                graph[0][x] = '_';
            }
            
            for (int h=0; h<m-1; h++) {
                for (int w=0; w<n-1; w++) {
                    char c = graph[h][w];
                    if (c == '_') continue;
                    if (c == graph[h+1][w] && c == graph[h][w+1] && c == graph[h+1][w+1]) {
                        pq.add(new int[]{h, w});
                        pq.add(new int[]{h+1, w});
                        pq.add(new int[]{h, w+1});
                        pq.add(new int[]{h+1, w+1});
                    }
                }
            }
        } while (!pq.isEmpty());
        
        return answer;
    }
}