class Solution {
    boolean solution(String s) {
        int count_p = 0;
        int count_y = 0;
        s = s.toLowerCase();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') count_p++;
            if (c == 'y') count_y++;
        }
        
        return count_p == count_y;
    }
}