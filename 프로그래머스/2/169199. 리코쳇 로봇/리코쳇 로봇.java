import java.util.*;

class Solution {
    Character[][] graph;
    boolean[][] visited;
    int h;
    int w;
    public int solution(String[] board) {
        int answer = 0;
        h = board.length;
        w = board[0].length();
        graph = new Character[h][w];
        visited = new boolean[h][w];
        int[] start = new int[2];
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};
        
        for (int y=0; y<h; y++) {
            String s = board[y];
            for (int x=0; x<w; x++) {
                char c = s.charAt(x);
                if (c == 'R') { // 시작점 초기화
                    start[0] = y;
                    start[1] = x;
                }
                graph[y][x] = c;
            }
        }
        visited[start[0]][start[1]] = true;
        dq.addLast(new int[]{start[0], start[1], 0});
        
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            for (int i=0; i<4; i++) {
                int[] result = move(cur[0], cur[1], dy[i], dx[i], cur[2]);
                int result_y = result[0];
                int result_x = result[1];
                int result_cost = result[2];
                
                if (graph[result_y][result_x] == 'G') return result_cost;
                if (!visited[result_y][result_x]) {
                    visited[result_y][result_x] = true;
                    dq.addLast(new int[]{result_y, result_x, result_cost});
                }
            }
        }
        
        return -1;
    }
    
public int[] move(int y, int x, int dy, int dx, int depth) {
    int ny = y;
    int nx = x;
    
    while (true) {
        // 다음 위치
        int nextY = ny + dy;
        int nextX = nx + dx;
        
        // 인덱스 초과
        if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
            break;
        }
        
        //장애물을 만나면
        if (graph[nextY][nextX] == 'D') {
            break;
        }
        
        // 실제 이동 업데이트
        ny = nextY;
        nx = nextX;
    }
    
    return new int[]{ny, nx, depth + 1};
}
}