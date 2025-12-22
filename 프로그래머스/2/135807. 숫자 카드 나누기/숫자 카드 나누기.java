class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i=1; i<arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        gcdA = canDivide(gcdA, arrayB) ? 0 : gcdA;
        gcdB = canDivide(gcdB, arrayA) ? 0 : gcdB;
        
        return Math.max(gcdA, gcdB);
    }
    
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public boolean canDivide(int n, int[] array) {
        for (int num : array) {
            if (num % n == 0) return true;
        }
        return false;
    }
}