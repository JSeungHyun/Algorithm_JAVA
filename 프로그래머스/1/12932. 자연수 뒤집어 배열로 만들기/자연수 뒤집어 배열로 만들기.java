import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> res = new ArrayList<>();
        
        while (n > 0) {
            res.add((int)(n % 10));
            n /= 10;
        }
        
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}