import java.util.*;

class Solution {
    Map<String, String> map = new HashMap<>();
    public String solution(String m, String[] musicinfos) {
        String answer = ""; // 제목
        int playTime = 0; // 정답의 재생된 시간
        String[] codes = new String[]{"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        for (int i=0; i<12; i++) {
            map.put(codes[i], String.valueOf((char)('a' + i)));
        }
        map.put("B#", "a");
        map.put("E#", "f");
        
        StringBuilder sb = new StringBuilder();
        String target = changeCode(m);
        for (String info : musicinfos) {
            String[] musicInfo = info.split(",");
            sb.setLength(0);
            int diff = getDiff(musicInfo[0], musicInfo[1]);
            String title = musicInfo[2];
            String code = changeCode(musicInfo[3]);
            
            int quot = diff / code.length();
            if (quot > 0) sb.append(code.repeat(quot));
            int remainder = diff % code.length();
            if (remainder > 0) sb.append(code.substring(0, remainder));
            
            String total = sb.toString();
            if (total.contains(target)) {
                if (diff > playTime) {
                    answer = title;
                    playTime = diff;
                }
            }
        }
        
        return "".equals(answer) ? "(None)" : answer;
    }
    
    public int getDiff(String start, String end) {
        int s = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
        int e = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
        
        return e - s;
    }
    
    public String changeCode(String code) {
        StringBuilder sb = new StringBuilder();
        char prev = code.charAt(0);
        
        for (int i=1; i<code.length(); i++) {
            char c = code.charAt(i);
            
            if ('#' == c) {
                sb.append(map.get(String.valueOf(prev) + '#'));
                prev = '-';
            } else {
                if (prev != '-') sb.append(map.get(String.valueOf(prev)));
                prev = c;
            }
        }
        
        if ('-' != prev) sb.append(map.get(String.valueOf(prev)));
        return sb.toString();
        
    }
}