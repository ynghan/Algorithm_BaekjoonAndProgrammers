import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int R , C = 8;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{-1,-1,-1, 0,0,0,1,1,1};
    static int[] dy = new int[]{-1,0,1,-1,0,1,-1,0,1};

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void moveWall() {
        for(int i = 7; i >= 0; i--) {
            for(int j = 0; j < 8; j++) {
                if(map[i][j] == '#') {
                    map[i][j] = '.';
                    if(i != 7) {
                        map[i+1][j] = '#';
                    }
                }
            }
        }
    }

    boolean foundWall() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(map[i][j] == '#')
                    return true;
            }
        }
        return false;
    }

    void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(7, 0));

        while(!queue.isEmpty()) {
            
            visited = new boolean[8][8];
            int size = queue.size();
            for(int t = 0; t < size; t++) {
                Point now = queue.poll();
                
                // 그 위치에 벽이 있으면 탐색 패스
                if(map[now.x][now.y] == '#') continue;
                
                // 맵에 벽이 없으면 종료
                if(!foundWall()) {
                    System.out.println(1);
                    return;
                }
                // 도착지 도착하면 종료
                if(now.x == 0 && now.y == 7) {
                    System.out.println(1);
                    return;
                }
                
                for(int i =0 ; i < 9; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    
                    // 가지치기
                    if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                    
                    if(map[nx][ny] == '#') continue;
                    if(visited[nx][ny]) continue;
                    
                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
            // 벽을 아래로 이동
            moveWall();
        }
        System.out.println(0);
    }

    void solve() {
        visited = new boolean[R][C];
        BFS();
    }

    void inputData() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        map = new char[8][8];
        for(int i = 0; i < 8; i++) {
            String str = br.readLine();
            for(int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.inputData();
        m.solve();
    }
}
