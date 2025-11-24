import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        try {
            while (left <= right && (left < sequence.length && right < sequence.length)) {
                if (sum == k) {
                    if (answer[1] - answer[0] > right - left) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                    sum -= sequence[left++];
                    sum += sequence[++right];
                } else if (sum < k) {
                    sum += sequence[++right];
                } else {
                    sum -= sequence[left++];
                }
            }
        } catch (Exception e) {
            return answer;
        }
        
        return answer;
    }
}