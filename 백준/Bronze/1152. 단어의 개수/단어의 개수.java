import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().strip().split(" ");
        if (s.length == 1 && s[0].isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(s.length);
        }
    }
}