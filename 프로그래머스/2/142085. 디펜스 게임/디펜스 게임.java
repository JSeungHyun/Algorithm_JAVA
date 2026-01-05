import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        // 지금까지 맞은 공격 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i=0; i<enemy.length; i++) {
            int attack = enemy[i];
            pq.add(attack);
            n -= attack;
            
            if (n >= 0) { // 전투가 가능
                answer++;
            } else {
                if (k <= 0) return answer; // 더이상 방어 불가
                // 방어 가능
                n += pq.poll(); // 지금까지 맞은 공격 중 제일 큰 공격 방어
                k--; // 방어권 횟수 차감
                answer++; // 라운드 증가
            }
        }
        return answer;
    }
}