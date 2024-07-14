import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dice = reader.readLine().split(" ");
        int[] arr = Arrays.stream(dice).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        
        if (arr[0] == arr[2]) {
            System.out.println(arr[0]*1000 + 10000);
        } else if (arr[0] == arr[1]) {
            System.out.println(arr[0]*100 + 1000);
        } else if (arr[1] == arr[2]) {
            System.out.println(arr[1]*100 + 1000);
        } else {
            System.out.println(arr[2]*100);
        }
    }
}