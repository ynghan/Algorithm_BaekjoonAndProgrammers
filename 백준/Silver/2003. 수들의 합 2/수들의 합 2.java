
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] sequence;
    static int start = 0;
    static int end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        sequence = new int[N];

        String[] s1 = reader.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(s1[i]);
        }

        int count = 0;

        while(end <= N && start <= end) {
            int sum = 0;
            for(int i = start; i < end; i++) {
                sum += sequence[i];
            }

            if(sum == M) {
                count++;
                start++;
                end++;
            }
            else if(sum < M) {
                end++;
            }
            else {
                start++;
            }
        }

        System.out.println(count);

    }
}
