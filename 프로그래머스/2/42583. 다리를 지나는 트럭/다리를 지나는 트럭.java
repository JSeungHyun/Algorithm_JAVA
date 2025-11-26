import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int total_weight = 0;
        int total_length = truck_weights.length;
        int idx = 0;
        
        if (weight >= truck_weights[idx]) {
            for (int i=0; i<bridge_length-1; i++) dq.add(0);
            int cur = truck_weights[idx++];
            dq.add(cur);
            total_weight = cur;
            answer++;
        }
        
        while (!dq.isEmpty()) {
            total_weight -= dq.poll();
            answer++;
            if (idx >= total_length) continue;
            if (total_weight + truck_weights[idx] <= weight) {
                int cur = truck_weights[idx++];
                dq.add(cur);
                total_weight += cur;
            } else {
                dq.add(0);
            }
        }
        
        return answer;
    }
}