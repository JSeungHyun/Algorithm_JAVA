import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i< players.length; i++) {
            // 시간 만료된 서버 제거
            while (!pq.isEmpty() && pq.peek() <= i) {
                pq.poll();
            }
            
            int player = players[i];
            if (player == 0) continue;
            
            int needServer = (player / m) - pq.size();
            if (needServer <= 0) continue;
            
            answer += needServer;
            for (int j=0; j<needServer; j++) pq.add(i + k);
                
        }
        
        return answer;
    }
}