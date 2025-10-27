import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        Deque<Character> q;
        
        for (int i=0; i<s.length(); i++) {
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
            
            first = sb.charAt(0);
            char last = sb.charAt(sb.length() - 1);
            if (first == ')' || first == ']' || first == '}' || 
                last == '(' || last == '[' || last == '{') continue;
            
            q = new ArrayDeque<>();
            boolean flag = true;
            for (char c : sb.toString().toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        q.addLast(c);
                        break;
                    default:
                        if (q.isEmpty()) {
                            flag = false;
                            break;
                        }
                        last = q.pollLast();
                        if ((c == ')') && (last != '(') ||
                            (c == ']') && (last != '[') ||
                            (c == '}') && (last != '{')) {
                            flag = false;
                            break;
                        }
                }
            }
            if (flag && q.isEmpty()) answer++;
        }
        
        return answer;
    }
}