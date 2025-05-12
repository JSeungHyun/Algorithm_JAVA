class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (x + y > k) {
                    continue;
                }
                answer += board[y][x];
            }    
        }
        
        return answer;
    }
}