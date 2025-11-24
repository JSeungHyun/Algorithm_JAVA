import java.util.*;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void dfs(int[][] arr, int h, int w, int depth) {
        if (depth == 1) {
            if (arr[h][w] == 0) answer[0]++;
            else answer[1]++;
            return;
        }
        
        boolean flag = true;
        int standard = arr[h][w];
        for (int y=h; y<h+depth; y++) {
            for (int x=w; x<w+depth; x++) {
                if (arr[y][x] != standard) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        
        if (flag) {
            if (arr[h][w] == 0) answer[0]++;
            else answer[1]++;
            return;
        } else {
            int next = depth / 2;
            dfs(arr, h, w, next);
            dfs(arr, h + next, w, next);
            dfs(arr, h, w + next, next);
            dfs(arr, h + next, w + next, next);
        }
    }
}