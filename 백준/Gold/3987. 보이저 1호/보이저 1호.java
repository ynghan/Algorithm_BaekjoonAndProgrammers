import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static char[][] board;

    // 상, 우, 하, 좌
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = reader.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = charArray[j];
            }
        }

        String[] s1 = reader.readLine().split(" ");
        int currentX = Integer.parseInt(s1[0]) - 1;
        int currentY = Integer.parseInt(s1[1]) - 1;

        HashMap<Integer, Character> dir = new HashMap<>();
        dir.put(0, 'U');
        dir.put(1, 'R');
        dir.put(2, 'D');
        dir.put(3, 'L');

        // 4방향(상, 우, 하, 좌)으로 시작
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < 4; i++) {
            int val = start(currentX, currentY, i);
            if (val == -1) {
                System.out.println(dir.get(i));
                System.out.println("Voyager");
                return;
            }
            if (val > max) {
                max = val;
                maxIdx = i;
            }
        }

        System.out.println(dir.get(maxIdx));
        System.out.println(max);
    }

    private static int start(int x, int y, int dir) {
        int count = 0;
        boolean[][][] visited = new boolean[N][M][4];

        // 반복 되는 부분
        while (x >= 0 && x < N && y >= 0 && y < M) {
            if (visited[x][y][dir]) {
                return -1; // 무한 루프 발생
            }
            visited[x][y][dir] = true;

            // 블랙홀(C)을 만나면 즉시 종료
            if (board[x][y] == 'C') {
                return count;
            }

            count++;

            // 방향 전환 로직
            if (board[x][y] == '/') {
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else dir = 2;
            } else if (board[x][y] == '\\') {
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else dir = 0;
            }

            // 다음 좌표 이동
            x += dx[dir];
            y += dy[dir];
        }

        return count;
    }
}
