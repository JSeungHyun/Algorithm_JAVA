import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = -1;
        int index = 0;

        for (int i=1; i<=9; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (result < cur) {
                result = cur;
                index = i;
            }
        }

        System.out.println(result);
        System.out.println(index);
    }
}