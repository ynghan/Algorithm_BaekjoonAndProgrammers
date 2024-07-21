import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int one = Integer.parseInt(reader.readLine());
        int two = Integer.parseInt(reader.readLine());
        int three = Integer.parseInt(reader.readLine());

        if(one == two && two == three) {
            System.out.println("Equilateral");
        } else if((one + two + three) == 180) {
            if(one == two || two == three || three == one) {
                System.out.println("Isosceles");
            } else if (one != two && two != three && three != one) {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}