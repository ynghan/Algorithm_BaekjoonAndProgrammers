import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        // 짐들
        int[][] items = new int[N+1][2];


        for(int i = 1; i <= N; i++) {
            String[] s1 = reader.readLine().split(" ");
            // 무게
            int w = Integer.parseInt(s1[0]);
            // 가치
            int v = Integer.parseInt(s1[1]);

            items[i][0] = w;
            items[i][1] = v;
        }

        int[][] dp = new int[N+1][K+1];


        /**
         * 무게 K 보다 작을 때, 최대값을 담는다.
         * 무게 K 보다 크다면, 담지 않는다.
         */
        // 물건
        for(int i = 1 ; i <= N; i++) {
            // 무게
            for(int j = 1; j <= K; j++) {
                // 배낭의 무게가 0이 아닌 경우 물건을 담을 수 있다.
                // 물건의 무게가 배낭의 최대 무게보다 큰 경우
                if(items[i][0] > j) {
                    if(i == 1) {
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                // 물건의 무게가 배낭의 최대 무게보다 작은 경우
                else {
                    if(i == 1) {
                        dp[i][j] = items[i][1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], items[i][1] + dp[i-1][j-items[i][0]]);
                    }
                }

            }
        }

        int max = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                if(dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);

    }
}
