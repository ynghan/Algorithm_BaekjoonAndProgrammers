
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        int[] result = new int[T];

        for(int i = 0 ; i < T;i++) {
            int N = Integer.parseInt(reader.readLine());
            String[] s = reader.readLine().split(" ");
            int[] wood_height = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(wood_height);


            int start = 0;
            int end = N-1;
            int idx = N-1;

            int[] row_difficulty = new int[N];
            while(start <= end) {
                if((N - idx) % 2 == 1) {
                    row_difficulty[start] = wood_height[idx];
                    start++;
                    idx--;
                }
                else {
                    row_difficulty[end] = wood_height[idx];
                    end--;
                    idx--;
                }
            }

            int max = 0;

            for(int j = 0; j < N; j++) {
                int abs = Math.abs(row_difficulty[j] - row_difficulty[(j + 1)%N]);
                if(max < abs) {
                    max = abs;
                }
            }

            result[i] = max;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
