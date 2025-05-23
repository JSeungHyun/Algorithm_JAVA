class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patLength = pat.length();
        for (int i=0; i <= myString.length() - patLength; i++) {
            String s = myString.substring(i, i + patLength);
            if (s.equals(pat)) {
                answer++;
            }
        }
        return answer;
    }
}