import java.util.*;

class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int i=0; i<orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = new String(c);
        }
        
        for (int c : course) {
            map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < c) continue;
                dfs(order, new StringBuilder(), c, 0);
            }
            
            if (map.isEmpty()) continue;
            int max = Collections.max(map.values());
            
            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        answer.add(key);
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String order, StringBuilder sb, int depth, int point) {
        int before_length = sb.length();
        if (before_length == depth) {
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for (int i=point; i<order.length(); i++) {
            sb.append(order.charAt(i));
            dfs(order, sb, depth, i + 1);
            sb.setLength(before_length);
        }
    }
}