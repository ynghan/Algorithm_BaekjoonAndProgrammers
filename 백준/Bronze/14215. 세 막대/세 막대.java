import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int max = 0;

        if ( array[0] == array[1] && array[1] == array[2]) {
            System.out.println(3*array[0]);
            return;
        } else {
            for(int i = 0; i < 3; i++) {
                if(max < array[i]) {
                    max = array[i];
                }
            }
        }

        if(max >= array[0] + array[1]) {
            System.out.println(2* (array[0] + array[1]) - 1);
        } else if (max >= array[1] + array[2]) {
            System.out.println(2* (array[1] + array[2]) - 1);
        } else if (max >= array[2] + array[0]) {
            System.out.println(2* (array[2] + array[0]) - 1);
        } else {
            System.out.println(array[0] + array[1] + array[2]);
        }
    }
}