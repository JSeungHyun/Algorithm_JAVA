import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String n = String.valueOf(a * b * c);
        int[] arr = new int[10];

        for (int i = 0; i < n.length(); i++) arr[Integer.parseInt(String.valueOf(n.charAt(i)))]++;

        for (int i : arr) {
            System.out.println(i);
        }
    }
}