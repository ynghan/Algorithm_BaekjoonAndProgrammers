import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] max = new int[2];
        max[0] = 0;
        for(int i = 0; i < 9; i++) {
            int num = Integer.parseInt(reader.readLine());
            if (num > max[0]) {
                max[0] = num;
                max[1] = i+1;
            }
        }
        System.out.println(max[0]);
        System.out.println(max[1]);
    }
}