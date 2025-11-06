import java.util.*;

public class EndException extends RuntimeException {}

class Solution {
    String[] words = {"A", "E", "I", "O", "U"};
    int answer = 0;
    int depth = 0;
    
    public int solution(String word) {
        try {
            dfs(new StringBuilder(), word);
        } catch (EndException e) {
            return answer;
        }
        return 0;
    }
    
    public void dfs(StringBuilder sb, String target) {
        if (sb.length() > 0) {
            depth++;
            if (target.equals(sb.toString())) {
                answer = depth;
                throw new EndException();
            }
        }
        
        if (sb.length() == 5) return;
        
        for (int i=0; i<5; i++) {
            sb.append(words[i]);
            dfs(sb, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}