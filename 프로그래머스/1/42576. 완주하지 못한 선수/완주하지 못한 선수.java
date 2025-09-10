import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            int n = map.get(c) - 1;
            if (n == 0) map.remove(c);
            else map.put(c, n);
        }
        
        return map.keySet().iterator().next();
    }
}