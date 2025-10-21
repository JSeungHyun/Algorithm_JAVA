import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int arr_size = (n + w - 1) / w;
        int target_x = -1;
        int[][] arr = new int[arr_size][w];
        int inc = 1;
        int number = 1;
        int answer = 0;
        
        for (int y = arr_size - 1; y >= 0; y--) {
            for (int x = 1; x <= w; x++) {
                if (number > n) break;
                int nx = inc == -1 ? w - x : x - 1;
                arr[y][nx] = number;
                if (number == num) target_x = nx;
                number++;
                
                if (nx == target_x) answer++;
            }
            inc *= -1;
        }
        
        return answer;
    }
}