import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] temp;
        int idx = 0;
        for (int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            temp = new int[command[1] - command[0] + 1];
            idx = 0;
            for (int j=command[0]; j <= command[1]; j++) {
                temp[idx++] = array[j - 1]; 
            }
            Arrays.sort(temp);
            answer[i] = temp[command[2] - 1];
        }
        return answer;
    }
}