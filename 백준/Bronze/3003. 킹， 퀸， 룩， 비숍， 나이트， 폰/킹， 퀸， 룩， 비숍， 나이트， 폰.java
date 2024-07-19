import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int[] full = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            if (i == 0 || i == 1) {
                full[i] = 1 - array[i];
            } else if (i == 5) {
                full[i] = 8 - array[i];
            } else {
                full[i] = 2 - array[i];
            }
        }

        for(int i = 0 ; i < full.length; i++) {
            System.out.print(full[i] + " ");
        }
    }
}