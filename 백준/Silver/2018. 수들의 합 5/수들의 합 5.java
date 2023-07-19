import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int MAX = 10000000;
    public static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N > MAX || N < 1 ) {
            return;
        }

        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while(end_index != N) {
            if( N == sum) {
                count++;
                end_index++;
                sum = sum + end_index;
            } else if(sum < N) {
                end_index++;
                sum += end_index;
            } else if ( sum > N) {
                sum -= start_index;
                start_index++;
            }
        }

        System.out.println(count);
    }
}
