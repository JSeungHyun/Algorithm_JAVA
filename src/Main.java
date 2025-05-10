import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int result = sol.solution(arr);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}