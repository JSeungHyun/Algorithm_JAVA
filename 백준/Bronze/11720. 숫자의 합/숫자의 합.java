import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(res);
    }
}
