import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        // 초기화
        int[] record = new int[elements.length * 2 + 1];
        
        for(int i=1; i<record.length; i++) {
            record[i] = elements[(i-1) % elements.length] + record[i - 1];
        }
        
        for (int i=1; i<=elements.length; i++) {
            for (int j=i; j<i+elements.length; j++) {
                if (set.add(record[j] - record[j-i])) answer++;
            }
        }
        return answer;
    }
}