import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> yValues = new ArrayList<>();
        yValues.add(k);
        
        while (k > 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            yValues.add(k);
        }
        
        double[] dp = new double[yValues.size()];
        int N = dp.length;
        for (int i=1; i<N; i++) {
            dp[i] = ((yValues.get(i) + yValues.get(i - 1)) / 2.0) + dp[i - 1];
        }
        
        double[] answer = new double[ranges.length];
        for (int i=0; i<ranges.length; i++) {
            int start = ranges[i][0];
            int end = N + ranges[i][1] - 1;
            
            if (start > end) {
                answer[i] = -1;
            } else {
                answer[i] = dp[end] - dp[start];
            }
        }
        
        return answer;
    }
}