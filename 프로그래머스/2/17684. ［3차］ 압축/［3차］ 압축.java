import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int value = 1;
        
        for (int i=0; i<26; i++) {
            String s = String.valueOf((char) ('A' + i));
            map.put(s, value++);
        }
        
        for (int i=0; i<msg.length(); i++) {
            sb.append(msg.charAt(i));
            String cur = sb.toString();
            if (i < msg.length() - 1) {
                String next = cur + msg.charAt(i + 1);
                if (map.getOrDefault(next, 0) != 0) continue;
                else {
                    map.put(next, value++);
                }
            } 
            
            sb.setLength(0);
            int v = map.getOrDefault(cur, 0);
            if (v != 0) {
                answer.add(v);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}