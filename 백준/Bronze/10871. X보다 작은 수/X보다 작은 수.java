import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int X = arr[1];

        String[] num = reader.readLine().split(" ");
        int[] num_arr = Arrays.stream(num).mapToInt(Integer::parseInt).toArray();


        for(int i = 0; i < N; i++) {
            if ( X > num_arr[i]) {
                System.out.print(num_arr[i] + " ");
            }
        }
    }
}