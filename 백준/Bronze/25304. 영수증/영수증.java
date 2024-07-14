import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(reader.readLine());
        int count = Integer.parseInt(reader.readLine());
        int answer = 0;
        for(int i = 0; i < count; i++) {
            String[] s = reader.readLine().split(" ");
            int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            answer += array[0] * array[1];
        }

        if (answer == price) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}