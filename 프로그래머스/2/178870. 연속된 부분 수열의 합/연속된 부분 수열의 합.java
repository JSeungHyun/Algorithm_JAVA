class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int answer_left = 0;
        int answer_right = Integer.MAX_VALUE;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                if (answer_right - answer_left > right - left) {
                    answer_left = left;
                    answer_right = right;
                }
            }
        }

        return new int[]{answer_left, answer_right};
    }
}
