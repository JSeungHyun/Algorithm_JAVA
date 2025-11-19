import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name_map = new HashMap<>();
        List<String> do_list = new ArrayList<>();
        
        for (String rec : record) {
            String command = rec.split(" ")[0];
            String id = rec.split(" ")[1];
            
            if ("Enter".equals(command) || "Leave".equals(command)) {
                if ("Enter".equals(command)) {
                    name_map.put(id, rec.split(" ")[2]);
                }
                do_list.add(command + " " + id);
            }
                
            
            if ("Change".equals(command)) name_map.put(id, rec.split(" ")[2]);
        }
        
        String[] answer = new String[do_list.size()];
        int idx = 0;
        for (String s : do_list) {
            StringBuilder sb = new StringBuilder();
            sb.append(name_map.get(s.split(" ")[1]));
            sb.append("님이 ");
            if ("Enter".equals(s.split(" ")[0])) sb.append("들어왔습니다.");
            else sb.append("나갔습니다.");
            
            answer[idx++] = sb.toString();
        }
        return answer;
    }
}