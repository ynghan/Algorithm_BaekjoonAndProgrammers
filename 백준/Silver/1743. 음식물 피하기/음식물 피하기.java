import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 세로 길이
    int N = Integer.parseInt(st.nextToken());
    // 가로 길이
    int M = Integer.parseInt(st.nextToken());
    // 음식물 개수
    int K = Integer.parseInt(st.nextToken());

    boolean[][] arr = new boolean[N+1][M+1];
    boolean[][] visited = new boolean[N+1][M+1];

    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[r][c] = true;

    }

    int max = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        int count = 0;
        if(arr[i][j] && !visited[i][j]) {
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
          while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            for(int k = 0; k < 4; k++) {
              int x = poll[0] + dx[k];
              int y = poll[1] + dy[k];
              if(x > 0 && y > 0 && x <= N && y <= M) {
                if(arr[x][y] && !visited[x][y]) {
                  queue.offer(new int[]{x,y});
                  visited[x][y] = true;
                }
              }
            }
          }
        }
        if(max < count) max = count;
      }
    }

    System.out.println(max);

  }
}