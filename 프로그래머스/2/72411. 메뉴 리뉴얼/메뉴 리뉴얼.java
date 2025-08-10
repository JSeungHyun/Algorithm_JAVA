import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 1. orders 정렬
        for (int i=0; i<orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = new String(order);
        }
        List<String> answer = new ArrayList<>();
        
        // 2. 메뉴 조합 찾기
        for (int i : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < i) continue;
                generateCombinations(order, i, 0, new StringBuilder(), map);
            }
            
            if (map.isEmpty()) continue;
            
            int max = 0;
            for (int v : map.values()) {
                if (v > max) max = v;
            }
            if (max < 2) continue;
            
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getValue() == max) answer.add(m.getKey());
            }
        }
        
        // 3. 오름차순 정렬 후 형변환 return
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void generateCombinations(String order, int r, int start,
                                  StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == r) {
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            generateCombinations(order, r, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}