class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        comb(1, 0, new int[5], n, q, ans);
        return answer;
    }
    
    public void comb(int start, int depth, int[] arr, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            calc(arr, q, ans);
            return;
        }
        
        for (int i=start; i<=n; i++) {
            arr[depth] = i;
            comb(i + 1, depth + 1, arr, n, q, ans);
        }
    }
    
    public void calc(int[] arr, int[][] q, int[] ans) {
        
        for (int i=0; i<q.length; i++) {
            int[] targetList = q[i];
            int targetCount = ans[i];
            int count = 0;
            
            for (int target : targetList) {
                if (count > targetCount) return;
                if (contains(target, arr)) count++;
            }
            if (count != targetCount) return;
        }
        
        answer++;
    }
    
    public boolean contains(int target, int[] arr) {
        for (int n : arr) {
            if (n == target) return true;
        }
        return false;
    }
}