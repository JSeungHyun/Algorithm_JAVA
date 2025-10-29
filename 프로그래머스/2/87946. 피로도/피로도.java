import java.util.*;

class ExitException extends RuntimeException {}

class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int total = dungeons.length;
        try {
            search(total, new boolean[total], k, 0, dungeons);
        } catch (ExitException e) {
            return total;
        }
        return answer;
    }
    
    public void search(int total, boolean[] visited, int current, int depth, int[][] dungeons) {
        if (total == depth) throw new ExitException();
        boolean flag = false;
        for (int i=0; i<visited.length; i++) {
            if (visited[i] || current < dungeons[i][0]) continue;
            flag = true;
            visited[i] = true;
            search(total, visited, current - dungeons[i][1], depth + 1, dungeons);
            visited[i] = false;
        }
        if (!flag) answer = Math.max(answer, depth);
    }
}