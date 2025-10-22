class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = Integer.bitCount(n);
        while (true) {
            n++;
            if(count == Integer.bitCount(n)){
                return n;
            }
        }
    }
}