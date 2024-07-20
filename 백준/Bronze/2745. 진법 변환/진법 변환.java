import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        char[] N = s[0].toCharArray();
        int B = Integer.parseInt(s[1]);
        double sum = 0;
        for(int i = 0; i < N.length; i++) {
            int x = N[i];
            if ( x > 48 && x < 58) {
                sum += (x-48) * Math.pow(B, N.length -1 - i);
            }
            else if ( x > 55) {
                sum += (x-55) * Math.pow(B, N.length -1 - i);
            }
        }
        System.out.println((int)sum);
    }
}
