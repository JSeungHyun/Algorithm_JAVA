import java.util.*;

class Solution {
    int solution(int[][] land) {
        int h = land.length;
        
        for (int i=1; i<h; i++) {
            land[i][0] = Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]) + land[i][0];
            land[i][1] = Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]) + land[i][1];
            land[i][2] = Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]) + land[i][2];
            land[i][3] = Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]) + land[i][3];
        }
        
        return Arrays.stream(land[h - 1]).max().orElse(0);
    }
}