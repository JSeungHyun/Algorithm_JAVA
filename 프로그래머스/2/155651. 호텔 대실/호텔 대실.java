import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Reserve> reserves = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (String[] time : book_time) {
            reserves.add(new Reserve(time));
        }
        Collections.sort(reserves, (i, j) -> i.start - j.start);
        
        for (Reserve r : reserves) {            
            if (pq.isEmpty()) {
                pq.offer(r.end);
                continue;
            }

            int item = pq.peek(); 

            if (r.start >= item) {
                pq.poll();
                pq.offer(r.end);
            } else {
                pq.offer(r.end);
            }
        }
        
        return pq.size();
    }
    
    class Reserve {
        int start;
        int end;
        
        public Reserve(String[] time) {
            this.start = getTime(time[0]);
            this.end = getTime(time[1]) + 10;
        }
        
        private int getTime(String s) {
            String[] parts = s.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
    }
}