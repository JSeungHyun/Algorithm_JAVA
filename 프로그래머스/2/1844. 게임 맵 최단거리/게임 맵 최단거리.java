import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Deque<Node> dq = new ArrayDeque<>();
        int target_y = maps.length;
        int target_x = maps[0].length;
        boolean[][] visited = new boolean[target_y][target_x];
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        // 시작점 초기화
        dq.addLast(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!dq.isEmpty()) {
            Node node = dq.pollFirst();
            if (node.y == target_y - 1 && node.x == target_x - 1) {
                answer = Math.max(answer, node.value);
                continue;
            }
            
            for (int i=0; i<4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                
                if (ny < 0 || ny >= target_y) continue;
                if (nx < 0 || nx >= target_x) continue;
                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                dq.addLast(new Node(ny, nx, node.value + 1));
            }
        }
        
        return answer;
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