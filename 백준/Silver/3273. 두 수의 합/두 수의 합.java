import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] sequence;
    static int start = 0;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        sequence = new int[N];

        String[] s = reader.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(sequence);
        end = N-1;

        int X = Integer.parseInt(reader.readLine());


        int count = 0;

        while(start < end) {
            int sum = sequence[start] + sequence[end];

            if(sum == X) {
                start++;
                end--;
                count++;
            }
            else if(sum > X) {
                end--;
            }
            else {
                start++;
            }
        }

        System.out.println(count);

    }
}

