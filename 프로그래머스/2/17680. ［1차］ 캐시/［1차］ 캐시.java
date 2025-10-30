import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (deque.contains(city)) {
                answer++;
                deque.remove(city);
                deque.addLast(city);
            } else {
                answer += 5;
                if (deque.size() >= cacheSize) {
                    deque.pollFirst();
                }
                deque.addLast(city);
            }
        }
        return answer;
    }
}