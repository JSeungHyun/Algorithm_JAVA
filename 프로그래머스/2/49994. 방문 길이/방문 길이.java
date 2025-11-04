import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, 1, -1};
        Set<String> set = new HashSet<>();
        int y = 0, x = 0;
        
        for (char d : dirs.toCharArray()) {
            int idx;
            if (d == 'D') idx = 0;
            else if (d == 'U') idx = 1;
            else if (d == 'R') idx = 2;
            else idx = 3;
            
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            
            if (ny < -5 || ny > 5 || nx > 5 || nx < -5) continue;
            
            int start_y;
            int start_x;
            int end_y;
            int end_x;
            
            if (x < nx || (x == nx && y < ny)) {
                start_x = x;
                start_y = y;
                end_x = nx;
                end_y = ny;
            } else {
                start_x = nx;
                start_y = ny;
                end_x = x;
                end_y = y;
            }
            
            if (set.add(Arrays.toString(new int[]{start_x, start_y, end_x, end_y}))) answer++;
            y = ny;
            x = nx;
        }
        
        return answer;
    }
}