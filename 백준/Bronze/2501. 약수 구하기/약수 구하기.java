import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int cnt = 0;
        for(int i = 1; i <= array[0]; i++) {
            if( array[0] % i == 0) {
                cnt++;
            }
        }
        int[] measure = new int[array[0]];

        for(int i = 1; i <= array[0]; i++) {
            if( array[0] % i == 0) {
                measure[i-1] = i;
            }
        }
        int zero = 0;
        for(int i = 0; i < array[0]; i++) {
            if (measure[i] == 0) {
                zero++;
            }
        }

        int a = array[0] - zero;
        if (a < array[1]) {
            System.out.println("0");
            return;
        } else {
            for(int i = 0; i < array[0]; i++) {
                if (measure[i] == 0) {
                    continue;
                } else {
                    array[1]-=1;
                    if(array[1]==0) {
                        System.out.println(measure[i]);
                    }
                }
            }
            System.out.println();
        }

    }
}