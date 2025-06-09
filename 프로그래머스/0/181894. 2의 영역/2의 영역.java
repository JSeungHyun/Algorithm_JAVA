import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int s = findTwoIndex(arr);
        if (s == -1) {
            int[] noneRes = {-1};
            return noneRes;
        }
        int e = findTwoLastIndex(arr);
        
        for (int i=s; i<=e; i++) {
            res.add(arr[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int findTwoIndex(int[] arr) {
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == 2)
                return i;
        }
        return -1;
    }
    
    public static int findTwoLastIndex(int[] arr) {
        for (int i=arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2)
                return i;
        }
        return -1;
    }
}