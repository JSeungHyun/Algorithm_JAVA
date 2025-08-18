import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (record[idx] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = i - (record[idx] - 1);
            }
            record[idx] = i + 1;
        }
        return answer;
    }
}