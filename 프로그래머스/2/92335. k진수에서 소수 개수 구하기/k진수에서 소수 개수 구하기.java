import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] s = Integer.toString(n, k).split("0");
        for (String st : s) {
            if (st.trim().length() < 1) continue;
            if (isPrime(Long.parseLong(st))) answer++;
        }
        return answer;
    }
    
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}