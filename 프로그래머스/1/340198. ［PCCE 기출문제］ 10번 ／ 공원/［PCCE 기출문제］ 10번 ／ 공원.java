import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length, w = park[0].length;
        int[][] dp = new int[h][w];
        int maxSq = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if ("-1".equals(park[y][x])) {
                    if (y == 0 || x == 0) {
                        dp[y][x] = 1;
                    } else {
                        dp[y][x] = 1 + Math.min(
                                dp[y-1][x],
                                Math.min(dp[y][x-1], dp[y-1][x-1])
                        );
                    }
                    maxSq = Math.max(maxSq, dp[y][x]);
                }
            }
        }

        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            if (mats[i] <= maxSq) return mats[i];
        }
        return -1;
    }
}