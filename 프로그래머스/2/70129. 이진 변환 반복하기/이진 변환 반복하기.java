import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int delCount = 0;
        int beforeLength;
        
        while (!s.equals("1")) {
            count++;
            beforeLength = s.length();
            s = s.replaceAll("0", "");
            delCount += beforeLength - s.length();
            s = Integer.toString(s.length(), 2);
        }

        return new int[]{count, delCount};
    }
}