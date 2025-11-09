import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int current = 0;
        int num = 0;
        p--;
        
        while (true) {
            if (sb.length() >= t) break;
            String changedNumber = Integer.toString(num, n);
            
            for (char c : changedNumber.toCharArray()) {
                if (current == p) {
                    sb.append(Character.toUpperCase(c));
                }
                current = (current + 1) % m;
            }
            
            num++;
        }
        
        
        return sb.toString().substring(0, t);
    }
}