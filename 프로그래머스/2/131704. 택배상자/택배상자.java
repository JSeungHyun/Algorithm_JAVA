import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> dq = new ArrayDeque<>();
        int target = 0;
        int answer = 0;
        
        for (int i=1; i<=order.length; i++) {
            if (target >= order.length) break;
            
            boolean flag = true;
            if (i == order[target]) {
                answer++;
                target++;
                flag = false;
            }
            
            while (!dq.isEmpty() && target < order.length && dq.peekLast() == order[target]) {
                dq.pollLast();
                answer++;
                target++;
            }
            
            if (flag) dq.addLast(i);
        }
        
        return answer;
    }
}