import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int r = Integer.parseInt(br.readLine());
        for (int i=1; i<=r; i++) {
            result += i;
        }
        System.out.println(result);
    }
}