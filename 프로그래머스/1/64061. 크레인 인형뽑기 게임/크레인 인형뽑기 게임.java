import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        int BOARD_SIZE = board.length;
        for (int move : moves) {
            for (int i=0; i<BOARD_SIZE; i++) {
                int cur = board[i][move - 1];
                if (cur == 0) continue;
                Integer last = queue.peekLast();
                if (last != null && last == cur) {
                    queue.pollLast();
                    answer += 2;
                } else {
                    queue.addLast(cur);
                }
                board[i][move - 1] = 0;
                break;
            }
        }
        
        return answer;
    }
}