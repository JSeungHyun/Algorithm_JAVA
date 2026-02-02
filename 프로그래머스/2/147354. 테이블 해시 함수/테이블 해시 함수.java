import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Integer> si_list = new ArrayList<>();
        
        // col 오름차순, 첫번째 컬럼 값 내림차순
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) return Integer.compare(o2[0], o1[0]);
            return Integer.compare(o1[col - 1], o2[col - 1]);
        });
        
        // S_i 구하기
        for (int i=row_begin; i <= row_end; i++) {
            int s = 0;
            int[] d = data[i - 1];
            for (int j=0; j<d.length; j++) {
                s += d[j] % i;
            }
            si_list.add(s);
        }
        
        // XOR
        if (si_list.size() < 2) return si_list.stream().findFirst().orElse(0);
        answer = si_list.get(0) ^ si_list.get(1);
        for (int i=2; i<si_list.size(); i++) {
            answer = answer ^ si_list.get(i);
        }
        
        return answer;
    }
}