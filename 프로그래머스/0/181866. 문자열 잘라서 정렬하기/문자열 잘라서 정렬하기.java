import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] parts = myString.split("x");

        List<String> filtered = new ArrayList<>();
        for (String s : parts) {
            if (!s.isEmpty()) {
                filtered.add(s);
            }
        }

        Collections.sort(filtered);
        return filtered.toArray(new String[0]);
    }
}