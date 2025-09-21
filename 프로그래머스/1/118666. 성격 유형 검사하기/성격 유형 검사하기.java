import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<survey.length; i++) {
            int choice = choices[i];
            if (choice <= 3) {
                String key = String.valueOf(survey[i].charAt(0));
                map.put(key, map.getOrDefault(key, 0) + 4 - choice);
            } else if (choice >= 5) {
                String key = String.valueOf(survey[i].charAt(1));
                map.put(key, map.getOrDefault(key, 0) + choice - 4);
            }
        }
        
        // 1번 지표
        if (map.getOrDefault("T", 0) > map.getOrDefault("R", 0)) {
            sb.append("T");
        } else {
            sb.append("R");
        }
        
        // 2번 지표
        if (map.getOrDefault("F", 0) > map.getOrDefault("C", 0)) {
            sb.append("F");
        } else {
            sb.append("C");
        }
        
        // 3번 지표
        if (map.getOrDefault("M", 0) > map.getOrDefault("J", 0)) {
            sb.append("M");
        } else {
            sb.append("J");
        }
        
        // 4번 지표
        if (map.getOrDefault("N", 0) > map.getOrDefault("A", 0)) {
            sb.append("N");
        } else {
            sb.append("A");
        }
        
        return sb.toString();
    }
}