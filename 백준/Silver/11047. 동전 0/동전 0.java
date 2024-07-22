import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int[] coins = new int[array[0]];

        for(int i = 0; i < array[0]; i++) {
            int coin = Integer.parseInt(reader.readLine());
            coins[i] = coin;
        }

        int num = array[1];
        int count = 0;
        for(int i = array[0]-1 ; i >= 0; i--) {
            if (coins[i] <= num) {
                count += num / coins[i];
                num = num % coins[i];
            }
        }

        System.out.println(count);

    }
}