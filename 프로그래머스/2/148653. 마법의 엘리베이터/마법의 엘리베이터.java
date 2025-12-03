import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int cur = storey % 10; // 현재 자리
            storey /= 10;
            
            if (cur > 5) {
                answer += 10 - cur;
                storey++;
            } else if (cur < 5) {
                answer += cur;
            } else { // 5
                answer += 5;
                if (storey % 10 >= 5) storey++;
            }
        }
        return answer;
    }
}