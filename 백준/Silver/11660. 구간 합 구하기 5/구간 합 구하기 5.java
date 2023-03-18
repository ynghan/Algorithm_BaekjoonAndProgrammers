import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        int[] result = new int[quizNo];
        int[][] S = new int[suNo + 1][suNo + 1];
        int[][] A = new int[suNo + 1][suNo + 1];

        for(int i = 1; i < suNo + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < suNo + 1 ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                S[i][j] = A[i][j] + S[i-1][j] + S[i][j-1] - S[i-1][j-1];
            }
        }

        for(int j = 0; j < quizNo ; j++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            result[j] = S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1];
        }

        for(int k = 0 ; k < quizNo ; k++) {
            System.out.println(result[k]);
        }



    }
}