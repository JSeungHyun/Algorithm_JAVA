import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Integer, Long> map = new HashMap<>();
        
        for (int w : weights) {
            map.put(w, map.getOrDefault(w, 0L) + 1L);
        }
        
        for (int w : map.keySet()) {
            long cnt = map.get(w);
            
            // 1:1
            if (cnt >= 2) answer += cnt * (cnt - 1) / 2;
            
            // 1:2
            int target = w * 2;
            answer += cnt * map.getOrDefault(target, 0L);
            
            // 2:3
            if (w % 2 == 0) {
                target = w / 2 * 3;
                answer += cnt * map.getOrDefault(target, 0L);
            }
            
            // 3:4
            if (w % 3 == 0) {
                target = w / 3 * 4;
                answer += cnt * map.getOrDefault(target, 0L);
            }
        }
        
        return answer;
    }
}