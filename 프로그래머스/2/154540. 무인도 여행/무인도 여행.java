import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int h = maps.length;
        int w = maps[0].length();
        char[][] graph = new char[h][w];
        boolean[][] visited = new boolean[h][w];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        Deque<int[]> dq;
        
        for (int y=0; y<h; y++) {
            String map = maps[y];
            for (int x=0; x<w; x++) {
                graph[y][x] = map.charAt(x);
            }
        }
        
        // 탐색 시작
        for (int y=0; y<h; y++) {
            for (int x=0; x<w; x++) {
                if ('X' != graph[y][x] && !visited[y][x]) {
                    int count = 0;
                    dq = new ArrayDeque<>();
                    visited[y][x] = true;
                    dq.addLast(new int[]{y, x, cost(graph[y][x])});
                    
                    while (!dq.isEmpty()) {
                        int[] cur = dq.pollFirst();
                        count += cur[2];
                        for (int i=0; i<4; i++) {
                            int ny = cur[0] + dy[i];
                            int nx = cur[1] + dx[i];
                            
                            if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
                            if (visited[ny][nx] || graph[ny][nx] == 'X') continue;
                            
                            visited[ny][nx] = true;
                            dq.addLast(new int[]{ny, nx, cost(graph[ny][nx])});
                        }
                    }
                    
                    answer.add(count);
                }
            }
        }
        
        if (answer.isEmpty()) return new int[]{-1};
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public int cost(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}