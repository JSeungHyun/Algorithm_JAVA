import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int index = -1;
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>(Comparator.reverseOrder());
        
        for (int i=0; i<priorities.length; i++) {
            int priority = priorities[i];
            List<Integer> li = tm.get(priority);
            
            if (li == null || li.isEmpty()) {
                li = new ArrayList<>();
                li.add(i);
                tm.put(priority, li);
            } else {
                li.add(i);
                tm.put(priority, li);
            }
        }
        
        for (Integer key : tm.keySet()) {
            List<Integer> index_list = tm.get(key);
            if (index_list.size() == 1) { // 단일
                index = index_list.get(0);
                answer++;
                if (index == location) return answer;
            } else { 
                List<Integer> left = new ArrayList<>();
                for (Integer idx : index_list) {
                    if (index > idx) {
                        left.add(idx);
                        continue;
                    }
                    index = idx;
                    answer++;
                    if (index == location) return answer;
                }
                
                for (Integer idx : left) {
                    index = idx;
                    answer++;
                    if (index == location) return answer;
                }
            }
        }
        
        return answer;
    }
}