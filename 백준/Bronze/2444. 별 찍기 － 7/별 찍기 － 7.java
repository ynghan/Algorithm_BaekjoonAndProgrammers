import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        for(int i = 1 ; i <= cnt; i++ ) {
            for(int j = 0; j < cnt-i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            
            System.out.println();
            
        }
        for(int i = cnt-1 ; i >= 1; i-- ) {
            for(int j = 0; j < cnt-i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            if(i != 1) {
                System.out.println();
            }
        }
    }
}