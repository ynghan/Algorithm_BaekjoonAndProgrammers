import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static int M;
    static int T;
    static List<Pos> aircon;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);

        board = new int[N][M];
        aircon = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            String[] s1 = reader.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int n = Integer.parseInt(s1[j]);
                board[i][j] = n;
                if(n == -1) {
                    aircon.add(new Pos(i,j));
                }
            }
        }

        for(int t = 0; t < T; t++) {
            diffusion();
            aircon();
        }

        System.out.println(calculateDust());
    }

    public static void diffusion() {
        int[][] diffusion_board = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] > 0) {
                    int val = board[i][j] / 5;
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] != -1) {
                            diffusion_board[nx][ny] += val;
                            count++;
                        }
                    }
                    diffusion_board[i][j] += board[i][j] - (val * count);
                }
            }
        }
        for(Pos ac : aircon) {
            diffusion_board[ac.x][ac.y] = -1;
        }
        board = diffusion_board;
    }

    public static void aircon() {
        int x1 = aircon.get(0).x;
        int x2 = aircon.get(1).x;
        
        // 위쪽 공기청정기 (반시계 방향)
        for(int i = x1-1; i > 0; i--) board[i][0] = board[i-1][0];
        for(int i = 0; i < M-1; i++) board[0][i] = board[0][i+1];
        for(int i = 0; i < x1; i++) board[i][M-1] = board[i+1][M-1];
        for(int i = M-1; i > 1; i--) board[x1][i] = board[x1][i-1];
        board[x1][1] = 0;
        
        // 아래쪽 공기청정기 (시계 방향)
        for(int i = x2+1; i < N-1; i++) board[i][0] = board[i+1][0];
        for(int i = 0; i < M-1; i++) board[N-1][i] = board[N-1][i+1];
        for(int i = N-1; i > x2; i--) board[i][M-1] = board[i-1][M-1];
        for(int i = M-1; i > 1; i--) board[x2][i] = board[x2][i-1];
        board[x2][1] = 0;
    }
    
    public static int calculateDust() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] > 0) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }
    
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}