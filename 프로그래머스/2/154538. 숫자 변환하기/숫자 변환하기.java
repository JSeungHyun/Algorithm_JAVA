import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] memory = new int[y + 1];
        Arrays.fill(memory, 1000000);
        memory[x] = 0;
        for (int i=x; i<y; i++) {
            if (i + n <= y) memory[i + n] = Math.min(memory[i + n], memory[i] + 1);
            if (i * 2 <= y) memory[2 * i] = Math.min(memory[2 * i], memory[i] + 1);
            if (i * 3 <= y) memory[3 * i] = Math.min(memory[3 * i], memory[i] + 1);
        }
        
        return memory[y] == 1000000 ? -1 : memory[y];
    }
}