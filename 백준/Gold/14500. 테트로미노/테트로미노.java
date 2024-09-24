import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] board;
    static int max = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s1 = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s1[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0, visited);
                checkTShape(i, j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int i, int j, int depth, int sum, boolean[][] visited) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        if (sum + (4 - depth) * 1000 <= max) return;  // 가지치기 최적화

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny], visited);
                visited[nx][ny] = false;
            }
        }
    }

    public static void checkTShape(int i, int j) {
        int sum = board[i][j];
        int minValue = Integer.MAX_VALUE;
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                sum += board[nx][ny];
                minValue = Math.min(minValue, board[nx][ny]);
                count++;
            }
        }

        if (count == 3) {
            max = Math.max(max, sum);
        } else if (count == 4) {
            max = Math.max(max, sum - minValue);
        }
    }
}