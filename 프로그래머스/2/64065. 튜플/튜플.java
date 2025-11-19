import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] s_arr = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(s_arr, Comparator.comparingInt(String::length));
        
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        
        for (String s1 : s_arr) {
            String[] temp = s1.replaceAll("\\{", "").replaceAll("\\}", "").split(",");
            for (String t : temp) {
                int n = Integer.parseInt(t);
                if (set.add(n)) answer.add(n);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}