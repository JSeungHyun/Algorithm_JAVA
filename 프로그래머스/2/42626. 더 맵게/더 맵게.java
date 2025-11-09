import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov : scoville) {
            pq.add(scov);
        }
        
        while (!pq.isEmpty()) {
            try {
                int first_scov = pq.poll();
                if (first_scov >= K) return answer;
                int second_scov = pq.poll();
                
                pq.add(first_scov + (second_scov * 2));
                answer++;
            } catch (Exception e) {
                return -1;
            }
        }
        return answer;
    }
}