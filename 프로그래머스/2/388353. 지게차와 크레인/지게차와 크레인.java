import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int height = storage.length;
        int width = storage[0].length();
        char[][] graph = new char[height + 2][width + 2];
        for (char[] g : graph) Arrays.fill(g, '_');
        
        for (int y=1; y<=height; y++) {
            for (int x=1; x<=width; x++) {
                graph[y][x] = storage[y-1].charAt(x-1);
            }
        }

        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        for (String req : requests) {
            char c = req.charAt(0);
            if (req.length() > 1) {
                for (int y=1; y<=height; y++) {
                    for (int x=1; x<=width; x++) {
                        if (graph[y][x] == c) graph[y][x] = '_';
                    }
                }
            } else {
                boolean[][] visited = new boolean[height+2][width+2];
                Deque<int[]> dq = new ArrayDeque<>();
                dq.addLast(new int[]{0,0});
                visited[0][0] = true;
                
                while (!dq.isEmpty()) {
                    int[] cur = dq.pollFirst();
                    int y = cur[0];
                    int x = cur[1];
                    
                    for (int i=0; i<4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        
                        if (ny < 0 || nx < 0 || ny >= height + 2 || nx >= width + 2) continue;
                        if (visited[ny][nx] || graph[ny][nx] != '_') continue;
                        visited[ny][nx] = true;
                        dq.addLast(new int[]{ny, nx});
                    }
                }
                
                for (int y=1; y<=height; y++) {
                    for (int x=1; x<=width; x++) {
                        if (graph[y][x] != c) continue;
                        boolean flag = false;
                        
                        for (int i=0; i<4; i++) {
                            int ny = y + dy[i];
                            int nx = x + dx[i];

                            if (ny < 0 || nx < 0 || ny >= height + 2 || nx >= width + 2) continue;
                            if (visited[ny][nx] && graph[ny][nx] == '_') {
                                flag = true;
                                break;
                            }
                        }
                        
                        if (flag) graph[y][x] = '_';
                    }
                }
            }
        }
        
        int answer=0;
        
        for (int y=1; y<=height; y++) 
            for (int x=1; x<=width; x++) 
                if (graph[y][x] != '_') answer++;
                
        return answer;
    }
}