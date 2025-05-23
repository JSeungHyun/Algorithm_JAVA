class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuffer prefix = new StringBuffer(my_string.substring(0, s));
        StringBuffer sb = new StringBuffer(my_string.substring(s, e + 1));
        StringBuffer postfix = new StringBuffer(my_string.substring(e + 1));

        return prefix.toString() + sb.reverse().toString() + postfix.toString();
    }
}