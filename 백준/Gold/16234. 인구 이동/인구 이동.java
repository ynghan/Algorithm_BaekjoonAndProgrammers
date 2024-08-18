import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, L, R;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] g = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(g[j]);
            }
        }

        int day = 0;

        while (true) {
            if (!movePopulation()) {
                break;
            }
            day++;
        }

        System.out.println(day);
    }

    public static boolean movePopulation() {
        visited = new boolean[N][N]; // 방문 배열 초기화
        boolean moved = false; // 이동 여부 확인
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    int sum = board[i][j];
                    int count = 1;
                    LinkedList<int[]> union = new LinkedList<>();
                    union.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int[] dir : directions) {
                            int ni = current[0] + dir[0];
                            int nj = current[1] + dir[1];

                            if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
                                int diff = Math.abs(board[current[0]][current[1]] - board[ni][nj]);
                                if (diff >= L && diff <= R) {
                                    visited[ni][nj] = true;
                                    queue.offer(new int[]{ni, nj});
                                    union.add(new int[]{ni, nj});
                                    sum += board[ni][nj];
                                    count++;
                                }
                            }
                        }
                    }

                    if (count > 1) {
                        moved = true; // 이동이 발생했음을 기록
                        int avg = sum / count;
                        for (int[] position : union) {
                            board[position[0]][position[1]] = avg; // 평균으로 인구 업데이트
                        }
                    }
                }
            }
        }

        return moved; // 이동이 발생했는지 여부 반환
    }
}
