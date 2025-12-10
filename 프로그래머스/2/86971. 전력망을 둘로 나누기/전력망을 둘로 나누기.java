import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int diff = n;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int s = wire[0];
            int e = wire[1];
            
            boolean[] visited = new boolean[n+1];
            Deque<Integer> dq = new ArrayDeque<>();
            dq.addLast(1);
            visited[1] = true;
            
            while (!dq.isEmpty()) {
                int ss = dq.pollFirst();
                for (int ee : graph.get(ss)) {
                    if ((ss == s && ee == e) || (ss == e && ee == s)) continue;
                    if (!visited[ee]) {
                        visited[ee] = true;
                        dq.addLast(ee);
                    }
                }
            }
            
            int cnt = 0;
            for (int i=1; i<=n; i++) {
                if (visited[i]) cnt++;
            }
            
            diff = Math.min(diff, Math.abs(cnt - n + cnt));
        }
        
        return diff;
    }
}