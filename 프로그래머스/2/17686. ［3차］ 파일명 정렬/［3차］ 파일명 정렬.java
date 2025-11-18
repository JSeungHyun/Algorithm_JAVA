import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> answer = new ArrayList<>();
        int idx = 0;
        
        for (String f : files) {
            boolean flag = false;
            int head_index = 0;
            int number_index = 0;
            
            for (int i=0; i<f.length(); i++) {
                char c = f.charAt(i);
                boolean isNumber = Character.isDigit(c);
                if (!flag && isNumber) { // flag flase -> true 면 head_index i
                    head_index = i;
                    flag = true;
                } else if (flag && !isNumber) { // flag true -> false면 number_index i
                    number_index = i;
                    break;
                }
            }
            if (number_index == 0) number_index = f.length();
            
            answer.add(
                new File(f, f.substring(0, head_index), f.substring(head_index, number_index), idx++)
            );
        }
        
        return answer.stream().sorted().map(File::getFullName).toArray(String[]::new);
    }
    
    public class File implements Comparable<File>{
        String full_name;
        String head;
        String number;
        int idx;
        
        public File(String full_name, String head, String number, int idx) {
            this.full_name = full_name;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
        
        public String getFullName() {
            return this.full_name;
        }
        
        @Override
        public int compareTo(File f) {
            int headCmp = this.head.compareToIgnoreCase(f.head);
            if (headCmp != 0) return headCmp;
            
            int n1 = Integer.parseInt(this.number);
            int n2 = Integer.parseInt(f.number);
            
            if (n1 == n2) return this.idx - f.idx;
            return n1 - n2;
        }
    }
}