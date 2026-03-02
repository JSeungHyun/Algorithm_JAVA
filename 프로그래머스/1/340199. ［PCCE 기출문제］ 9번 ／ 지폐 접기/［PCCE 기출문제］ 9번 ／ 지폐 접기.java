import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wallet_big = Math.max(wallet[0], wallet[1]);
        int wallet_min = Math.min(wallet[0], wallet[1]);
        int bill_big = Math.max(bill[0], bill[1]);
        int bill_min = Math.min(bill[0], bill[1]);
        
        while (true) {
            if (wallet_big >= bill_big && wallet_min >= bill_min) return answer;
            
            answer++;
            bill_big /= 2;
            if (bill_big < bill_min) {
                int temp = bill_big;
                bill_big = bill_min;
                bill_min = temp;
            }
        }
    }
}