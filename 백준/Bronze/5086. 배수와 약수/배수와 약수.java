import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] s = reader.readLine().split(" ");
            int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            if(array[0] == 0 && array[1] == 0) {
                break;
            }

            if (array[0] % array[1] == 0) {
                System.out.println("multiple");
            } else if (array[1] % array[0] == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }

    }
}
