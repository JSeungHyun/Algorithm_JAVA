import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] first_answer = {1, 2, 3, 4, 5};
        int[] second_answer = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_answer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int first = 0, second = 0, third = 0;
        
        for (int i=0; i<answers.length; i++) {
            int res = answers[i];
            if (res == first_answer[i % first_answer.length]) first++;
            if (res == second_answer[i % second_answer.length]) second++;
            if (res == third_answer[i % third_answer.length]) third++;
        }
        
        int max_value = Math.max(first, Math.max(second, third));
        if (first == max_value) answer.add(1);
        if (second == max_value) answer.add(2);
        if (third == max_value) answer.add(3);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}