import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] alphas = numbers.toCharArray();
        search(alphas, new boolean[numbers.length()], new StringBuilder());
        return set.size();
    }
    
    public void search(char[] alphas, boolean[] visited, StringBuilder sb) {
        if (sb.length() != 0) {
            int n = Integer.parseInt(sb.toString());
            if (!set.contains(n) && isPrime(n)) set.add(n);
        }
        
        for (int i=0; i<alphas.length; i++) {
            if (!visited[i]) {
                int before = sb.length();
                visited[i] = true;
                sb.append(alphas[i]);
                search(alphas, visited, sb);
                visited[i] = false;
                sb.setLength(before);
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}