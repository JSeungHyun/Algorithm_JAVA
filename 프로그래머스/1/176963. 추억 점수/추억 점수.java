import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int score = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        for (int i=0; i<photo.length; i++) {
            score = 0;
            String[] p = photo[i];
            for (String p2 : p) {
                score += map.getOrDefault(p2, 0);
            }
            answer[i] = score;
        }
        return answer;
    }
}