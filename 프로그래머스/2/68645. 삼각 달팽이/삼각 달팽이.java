import java.util.*;

class Solution {
    public int[] solution(int n) {
        if (n==1) return new int[]{1};
        
        List<int[]> memory = new ArrayList<>();
        Set<List<Integer>> visited = new HashSet<>();
        int[][] move = {{1, 0}, {0, 1}, {-1, -1}};
        int y = 0;
        int x = 0;
        int direct = 0;
        int value = 1;
        visited.add(Arrays.asList(y, x));
        
        for (int i=0; i<n; i++) {
            memory.add(new int[i + 1]);
        }
        
        memory.get(y)[x] = value++;
        while (true) {
            int ny = y + move[direct][0];
            int nx = x + move[direct][1];
            
            if (ny >= n || nx >= ny + 1 || !visited.add(Arrays.asList(ny, nx))) {
                direct = (direct + 1) % 3;
                int next_y = y + move[direct][0];
                int next_x = x + move[direct][1];
                
                if (visited.contains(Arrays.asList(next_y, next_x))) 
                    break;
            } else {
                y = ny;
                x = nx;
                memory.get(y)[x] = value++;
            }
        }
        
        return memory.stream()
            .flatMapToInt(Arrays::stream)
            .toArray();
    }
}