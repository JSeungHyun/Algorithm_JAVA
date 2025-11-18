import java.util.*;
class Solution {
    public int solution(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i=3; i<=n; i++) dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        return dp[n];
    }
}

/*
1-1
2-2
3-3
4-5
5-8
*/
    