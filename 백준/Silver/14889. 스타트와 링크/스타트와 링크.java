import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] board;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        boolean[] visited = new boolean[N];
        selectTeam(visited, 0, 0);
        System.out.println(minDifference);
    }

    static void selectTeam(boolean[] visited, int start, int count) {
        if (count == N / 2) {
            calculateDifference(visited);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            selectTeam(visited, i + 1, count + 1);
            visited[i] = false;
        }
    }

    static void calculateDifference(boolean[] visited) {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeamScore += board[i][j] + board[j][i];
                }
            }
        }

        int difference = Math.abs(startTeamScore - linkTeamScore);
        minDifference = Math.min(minDifference, difference);
    }
}