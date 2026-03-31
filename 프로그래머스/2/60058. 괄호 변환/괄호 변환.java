import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return p;
        
        int idx = getIndex(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        if (isValid(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }
    
    public int getIndex(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count == 0) return i + 1;
        }
        return s.length();
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}