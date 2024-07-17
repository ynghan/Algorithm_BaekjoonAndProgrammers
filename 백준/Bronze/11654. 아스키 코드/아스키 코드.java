import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = reader.readLine().toCharArray();
        char a = charArray[0];
        int a1 = a;
        System.out.println(a1);
    }
}