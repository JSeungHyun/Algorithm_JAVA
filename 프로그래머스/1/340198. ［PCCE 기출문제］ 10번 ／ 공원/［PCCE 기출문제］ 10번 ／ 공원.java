import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        
        for (int idx=mats.length - 1; idx >= 0; idx--) {
            int n = mats[idx];
            
            for (int y=0; y<=park.length - n; y++) {
                for (int x=0; x<=park[0].length - n; x++) {
                    boolean flag = true;
                    
                    taken:
                    for (int dy=y; dy<y+n; dy++) {
                        for (int dx=x; dx<x+n; dx++) {
                            if (!park[dy][dx].equals("-1")) {
                                flag = false;
                                break taken;
                            }
                        }
                    }
                    
                    if (flag) return n;
                }
            }
        }
        
        return -1;
    }
}