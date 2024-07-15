import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] string = reader.readLine().split(" ");
        int[] array = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int M = array[1];
        int[] bucket = new int[N];

        for(int i = 0; i < N; i++) {
            bucket[i] = i+1;
        }

        for(int i = 0; i < M ; i++) {
            String[] str = reader.readLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            int temp = bucket[arr[0]-1];
            bucket[arr[0]-1] = bucket[arr[1]-1];
            bucket[arr[1]-1] = temp;
        }

        for(int i = 0; i < N; i++) {
            System.out.print(bucket[i] + " ");
        }
    }
}