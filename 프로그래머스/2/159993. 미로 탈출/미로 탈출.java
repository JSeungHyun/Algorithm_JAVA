import java.util.*;

class Solution {
    int height;
    int width;
    
    public int solution(String[] maps) {        
        // 그래프 초기화 및 시작지점, 레버, 출구 좌표 초기화
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        height = maps.length;
        width = maps[0].length();
        
        int[][] graph = new int[height][width];
        for (int y=0; y<height; y++) {
            String map = maps[y];
            for (int x=0; x<width; x++) {
                char c = map.charAt(x);
                
                if (c == 'X') graph[y][x] = -1;
                else {
                    if (c == 'S') {
                        start[0] = y;
                        start[1] = x;
                    } else if (c == 'L') {
                        lever[0] = y;
                        lever[1] = x;
                    } else if (c == 'E') {
                        end[0] = y;
                        end[1] = x;
                    }
                    graph[y][x] = 0;
                }
            }
        }
        
        // 시작지점 -> 레버
        int first = bfs(start, lever, graph);
        if (first <= 0) return -1;
        
        // 레버 -> 출구
        int second = bfs(lever, end, graph);
        if (second <= 0) return -1;
        
        return first + second;
    }
    
    public int bfs(int[] start, int[] target, int[][] graph) {
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, 1, -1};
        boolean[][] visited = new boolean[height][width];
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            if (node.y == target[0] && node.x == target[1]) return node.value;
            
            for (int i=0; i<4; i++) {
                int y = node.y + dy[i];
                int x = node.x + dx[i];
                
                if (y < 0 || x < 0 || y >= height || x >= width) continue; // 범위 밖
                if (visited[y][x] || graph[y][x] == -1) continue;
                
                visited[y][x] = true;
                dq.addLast(new Node(y, x, node.value + 1));
            }
        }
        
        return -1;
    }
    
    public class Node {
        int y;
        int x;
        int value;
        
        public Node(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}