class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int h = 1, w = yellow;
        
        while (h <= w) {
            if ((w + 2) * 2 + (h * 2) == brown) {
                answer[0] = w + 2;
                answer[1] = h + 2;
                break;
            }
            
            while (true) {
                h++;
                if (yellow % h == 0) {
                    w = yellow / h;
                    break;
                }
            }
        }
        
        return answer;
    }
}