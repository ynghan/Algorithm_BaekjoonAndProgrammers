import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int max_x = -10000;
        int min_x = 10000;
        int max_y = -10000;
        int min_y = 10000;

        for(int i = 0; i < num; i++) {
            String[] s = reader.readLine().split(" ");
            int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            if (max_x < array[0]) {
                max_x = array[0];
            }
            if (min_x > array[0]){
                min_x = array[0];
            }
            if (max_y < array[1]) {
                max_y = array[1];
            }
            if (min_y > array[1]){
                min_y = array[1];
            }
        }
        System.out.println((max_x-min_x) * (max_y-min_y));
    }
}