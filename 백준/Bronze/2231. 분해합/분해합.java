import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        int num = Integer.parseInt(str);

        int min = num;

        for(int i = num-1; i > 0; i--) {
            int add = i;
            int integer = i;
            int length = Integer.toString(integer).length();
            for(int j = 0; j < length; j++) {
                add += (int) (integer / Math.pow(10, length - 1 - j));
                integer = (int) (integer % Math.pow(10, length - 1 - j));
            }
            if (add == num) {
                if(i < min) {
                    min = i;
                }
            }
        }
        if (min == num) {
            System.out.println("0");
        } else {
            System.out.println(min);
        }
    }
}