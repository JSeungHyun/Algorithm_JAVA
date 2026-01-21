import java.util.*;

class Solution {
    int[][] graph;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        graph = new int[rows][columns];
        
        // Graph 초기화
        int idx = 1;
        for (int y=0; y<rows; y++) {
            for (int x=0; x<columns; x++) {
                graph[y][x] = idx++;
            }
        }
        
        for (int i=0; i<queries.length; i++) {
            answer[i] = move(queries[i]);
        }
        
        return answer;
    }
    
    public int move(int[] query) {
        int y1 = query[0] - 1;
        int x1 = query[1] - 1;
        int y2 = query[2] - 1;
        int x2 = query[3] - 1;
        int prev = graph[y1][x1];
        int result = 10001;
        int cur;
        
        // right
        for (int x=x1+1; x<=x2; x++) {
            cur = graph[y1][x];
            result = Math.min(result, cur);
            graph[y1][x] = prev;
            prev = cur;
        }
        
        // down
        for (int y=y1+1; y<=y2; y++) {
            cur = graph[y][x2];
            result = Math.min(result, cur);
            graph[y][x2] = prev;
            prev = cur;
        }
        
        // left
        for (int x=x2-1; x>=x1; x--) {
            cur = graph[y2][x];
            result = Math.min(result, cur);
            graph[y2][x] = prev;
            prev = cur;
        }
        
        // up
        for (int y=y2-1; y>=y1; y--) {
            cur = graph[y][x1];
            result = Math.min(result, cur);
            graph[y][x1] = prev;
            prev = cur;
        }
        
        return result;
    }
}