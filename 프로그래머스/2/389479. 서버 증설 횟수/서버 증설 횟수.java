import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<players.length; i++) {
            boolean flag = false;
            while (!pq.isEmpty() && pq.peek() <= i) pq.poll();
            int player = players[i];
            int need = player / m; // 필요 서버의 수
            int cur = pq.size();
            
            if (need > cur) {
                answer += need - cur;
                for (int j=0; j < need - cur; j++) pq.add(i + k);
            }
        }
        
        return answer;
    }
}