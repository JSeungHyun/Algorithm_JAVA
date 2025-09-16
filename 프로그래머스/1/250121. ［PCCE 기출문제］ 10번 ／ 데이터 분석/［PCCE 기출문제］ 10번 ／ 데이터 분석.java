import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        
        for (int[] item : data) {
            int target = item[map.get(ext)];
            if (target < val_ext) list.add(item);
        }
        
        list.sort(Comparator.comparing(x -> x[map.get(sort_by)]));
        return list.toArray(int[][]::new);
    }
}