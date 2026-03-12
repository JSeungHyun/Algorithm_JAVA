import java.util.*;

class Solution {
    int[] discounts = new int[]{10, 20, 30, 40};
    int maxJoiners = 0;
    int maxRevenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] emoticonRates = new int[emoticons.length];
        dfs(0, emoticonRates, users, emoticons);
        return new int[]{maxJoiners, maxRevenue};
    }
    
    public void dfs(int depth, int[] emoticonRates, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            calculate(emoticonRates, users, emoticons);
            return;
        }
        
        for (int discount : discounts) {
            emoticonRates[depth] = discount;
            dfs(depth + 1, emoticonRates, users, emoticons);
        }
    }
    
    public void calculate(int[] emoticonRates, int[][] users, int[] emoticons) {
        int currentJoiners = 0; // 총 가입자
        int currentRevenue = 0; // 수익
        
        for (int[] user : users) {
            int baseRate = user[0]; // 할인률 기준
            int baseAmount = user[1]; // 금액 기준
            int userAmount = 0; // 할인 상품 구매 시 유저가 쓰는 금액
            
            for (int i=0; i<emoticons.length; i++) {
                if (emoticonRates[i] >= baseRate) {
                    userAmount += emoticons[i] * (100 - emoticonRates[i]) / 100;
                }
            }
            
            if (userAmount >= baseAmount) {
                currentJoiners++;
            } else {
                currentRevenue += userAmount;
            }
        }
        
        if (maxJoiners < currentJoiners) {
            maxJoiners = currentJoiners;
            maxRevenue = currentRevenue;
        } else if (maxJoiners == currentJoiners) {
            maxRevenue = Math.max(maxRevenue, currentRevenue);
        }
    }
}