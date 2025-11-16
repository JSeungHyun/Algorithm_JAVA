import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> list = new ArrayList<>();
        for (char c : skill.toCharArray()) list.add(c);
        
        for (String skill_tree : skill_trees) {
            int v = -2;
            boolean flag = false;
            for (Character c : list) {
                int io = skill_tree.indexOf(c);
                if (flag && io != -1) {
                    v = -1;
                    break;
                } 
                
                if (io == -1) {
                    flag = true;
                } else if (v < io) {
                    v = io;
                } else {
                    v = -1;
                    break;
                }
            }
            
            if (v == -2 || v >= 0) answer++;
        }
        return answer;
    }
}