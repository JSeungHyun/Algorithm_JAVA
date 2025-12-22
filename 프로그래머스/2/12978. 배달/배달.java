import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] visited = new int[N + 1];
        Arrays.fill(visited, 500001);
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        visited[1] = 0;
        dq.addLast(1);
        
        while (!dq.isEmpty()) {
            int item = dq.pollFirst();
            int cur = visited[item];
            
            for (int[] node : graph.get(item)) {
                int destination = node[0];
                int value = cur + node[1];
                if (value > K || visited[destination] <= value) continue;
                dq.add(destination);
                visited[destination] = value;
            }
        }
        
        int answer = 0;
        for (int v : visited) {
            if (v <= K) answer++;
        }
        return answer;
    }
}