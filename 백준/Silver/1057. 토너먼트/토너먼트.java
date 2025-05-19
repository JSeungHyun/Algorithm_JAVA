import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int result = 1;

        while (Math.ceil(kim / 2.0) != Math.ceil(lim / 2.0)) {
            result++;
            kim = (int) Math.ceil(kim / 2.0);
            lim = (int) Math.ceil(lim / 2.0);
        }

        System.out.println(result);
    }
}
