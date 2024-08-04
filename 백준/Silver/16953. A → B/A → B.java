import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int count = 1;

        while(B > A) {
            if((B % 10) % 2 == 0) {
                B = B / 2;
                count++;
            }
            else if ( B % 10 == 1 ) {
                B = B / 10;
                count++;
            }
            else {
                System.out.println(-1);
                return;
            }
        }

        if(B == A) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }
}
