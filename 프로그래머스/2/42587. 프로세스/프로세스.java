import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int i=0; i<priorities.length; i++) {
            int priority = priorities[i];
            pq.add(priority);
            dq.addLast(new int[]{priority, i});
        }
        
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            while (true) {
                int[] arr = dq.pollFirst();
                if (arr[0] == cur) {
                    answer++;
                    if (arr[1] == location) return answer;
                    break;
                } else {
                    dq.addLast(arr);
                }
            }
        }
        return answer;
    }
}