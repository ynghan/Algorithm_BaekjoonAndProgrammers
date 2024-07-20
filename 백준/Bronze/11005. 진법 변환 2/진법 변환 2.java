import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);

        int cnt = 0;
        int temp = N;
        while(temp / B > 0) {
            temp = temp / B;
            cnt++;
        }

        char[] arr = new char[cnt + 1];
        int index = 0;
        while (N > 0) {
            int remain = N % B;
            remain = (remain > 9) ? remain + 55 : remain + 48;
            arr[index++] = (char) remain;
            N = N / B;
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}