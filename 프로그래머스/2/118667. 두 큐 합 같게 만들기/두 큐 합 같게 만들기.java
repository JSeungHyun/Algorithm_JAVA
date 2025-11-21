import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();
        long q1_sum = 0;
        long q2_sum = 0;
        
        for (int q1 : queue1) {
            dq1.addLast(q1);
            q1_sum += q1;
        }
        for (int q2 : queue2) {
            dq2.addLast(q2);
            q2_sum += q2;
        }

        for (int i=0; i<queue1.length * 3; i++) {
            if (q1_sum == q2_sum) return i;
            else if (q1_sum > q2_sum) {
                int q = dq1.pollFirst();
                q1_sum -= q;
                q2_sum += q;
                dq2.addLast(q);
            } else {
                int q = dq2.pollFirst();
                q1_sum += q;
                q2_sum -= q;
                dq1.addLast(q); 
            }
        }
        
        return -1;
    }
}