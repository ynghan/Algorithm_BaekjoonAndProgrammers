import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = reader.readLine().toCharArray();

        for(int i = 0; i < charArray.length/2 + 1; i++) {
            if (i < charArray.length -1 -i) {
                if (charArray[i] != charArray[charArray.length-1-i]) {
                    System.out.println("0");
                    return;
                }
            } else {
                break;
            }
        }
        System.out.println("1");

    }
}