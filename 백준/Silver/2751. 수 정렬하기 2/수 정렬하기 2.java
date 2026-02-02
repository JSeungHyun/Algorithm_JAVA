import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        
        Integer n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}