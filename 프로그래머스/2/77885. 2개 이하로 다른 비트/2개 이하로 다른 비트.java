class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            long cur = numbers[i];
            if (cur % 2 == 0) answer[i] = cur + 1;
            else {
                String s = Long.toString(cur, 2);
                int idx = s.lastIndexOf("0");
                if (idx == -1) {
                    s = "0" + s;
                    idx = 0;
                }
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(idx, '1');
                if (sb.charAt(idx + 1) == '0') sb.setCharAt(idx + 1, '1');
                else sb.setCharAt(idx + 1, '0');
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        return answer;
    }
}