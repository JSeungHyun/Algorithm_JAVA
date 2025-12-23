import java.util.*;

class Solution {
    public String solution(int n) {
        if (n == 1) return "1";
        
        StringBuilder sb = new StringBuilder();
        int[] numbers = new int[]{4, 1, 2};
        
        while (n > 0) {
            int mod = n % 3;
            sb.append(numbers[mod]);
            n /= 3;
            if (mod == 0) n--;
        }
        
        return sb.reverse().toString();
    }
}


