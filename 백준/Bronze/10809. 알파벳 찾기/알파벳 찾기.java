import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        char[] input = reader.readLine().toCharArray();
        int[] check = new int[arr.length];
        Arrays.fill(check, 0);

        for(int i = 0; i < input.length; i++) {
            int j = input[i] - 97;
            if(check[j] == 0) {
                check[j] = 1;
                arr[j] = i;
            }
        }

        for (int i = 0 ; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length-1]);
    }
}