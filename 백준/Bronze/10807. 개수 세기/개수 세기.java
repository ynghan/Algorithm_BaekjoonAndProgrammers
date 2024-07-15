import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");

        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        int value = Integer.parseInt(reader.readLine());
        int answer = 0;

        for(int i = 0; i < N; i++) {
            if (arr[i] == value) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}