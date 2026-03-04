import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean flag;
        for (int i=0; i<schedules.length; i++) {
            flag = true;
            int time_limit = (schedules[i] / 100 * 60) + (schedules[i] % 100) + 10;
            int days = startday - 1;
            
            for (int time : timelogs[i]) {
                days = (days + 1) % 7;
                if (days == 6 || days == 0) continue;
                
                int target_time = (time / 100 * 60) + (time % 100);
                if (target_time > time_limit) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
}