import java.util.*;

class Solution {
    public String solution(String new_id) {
        String s = new_id.toLowerCase(); // 1단계
        s = s.replaceAll("[^a-z0-9-_.]", ""); // 2단계
        s = s.replaceAll("[.]{2,}", "."); // 3단계
        s = s.replaceAll("^[.]|[.]$", ""); // 4단계
        if (s.isEmpty()) s = "a"; // 5단계
        if (s.length() > 15) s = s.substring(0, 15); // 6단계
        s = s.replaceAll("[.]$", ""); // 6-1
        while(s.length() < 3) s += s.charAt(s.length() - 1); // 7단계
        return s;
    }
}