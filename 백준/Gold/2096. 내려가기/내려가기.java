import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        board = new int[N][3];

        for(int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        // max와 min 배열 초기화
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];

        // 첫 번째 줄 초기화
        for (int j = 0; j < 3; j++) {
            dpMax[0][j] = board[0][j];
            dpMin[0][j] = board[0][j];
        }

        // DP 테이블 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMax[i][j] = board[i][j] + Math.max(dpMax[i-1][j], dpMax[i-1][j+1]);
                    dpMin[i][j] = board[i][j] + Math.min(dpMin[i-1][j], dpMin[i-1][j+1]);
                } else if (j == 1) {
                    dpMax[i][j] = board[i][j] + Math.max(dpMax[i-1][j-1], Math.max(dpMax[i-1][j], dpMax[i-1][j+1]));
                    dpMin[i][j] = board[i][j] + Math.min(dpMin[i-1][j-1], Math.min(dpMin[i-1][j], dpMin[i-1][j+1]));
                } else {
                    dpMax[i][j] = board[i][j] + Math.max(dpMax[i-1][j-1], dpMax[i-1][j]);
                    dpMin[i][j] = board[i][j] + Math.min(dpMin[i-1][j-1], dpMin[i-1][j]);
                }
            }
        }

        // 최댓값과 최솟값 계산
        int max = Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2]));
        int min = Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2]));

        System.out.print(max + " ");
        System.out.print(min);
    }
}
