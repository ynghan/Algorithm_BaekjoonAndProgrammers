import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(arr[0] + " " + arr[N-1]);
    }
}