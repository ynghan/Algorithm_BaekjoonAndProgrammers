import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 로봇 청소기 : 로봇 청소기의 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하기
 * 방 : N * M 크기의 직사각형
 * 각각의 칸은 벽 또는 빈칸
 * 청소기는 방향이 있다. 동서남북
 * 가장 북쪽 줄의 가장 서쪽 칸의 좌표는 0,0 / N-1, M-1
 * 1. 현재 칸이 청소되지 않았다면, 현재 칸을 청소
 * 2. 현재 칸의 주변 4칸이 청소되지 않은 빈칸이 없다면, 후진.
 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있다면, 전방에 청소되지 않은 빈칸이 있을 때 까지 반시계 방향으로 회전, 그리고 전진
 *
 */

public class Main {

    static int N;
    static int M;

    //0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
    static int[] dir = new int[] {0, 1, 2, 3};
    // 북, 동, 남, 서
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    // Move 함수로 boolean 확인할 때, true를 반환함과 동시에 이동하기 위해 static 선언
    static int r;
    static int c;
    static int idx;

    static int[][] room;
    static boolean[][] wall;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        // 가로
        N = Integer.parseInt(s[0]);
        // 세로
        M = Integer.parseInt(s[1]);

        // 방
        room = new int[N][M];
        wall = new boolean[N][M];


        String[] s1 = reader.readLine().split(" ");

        // 현재 청소기 좌표 ( r,c )
        r = Integer.parseInt(s1[0]);
        c = Integer.parseInt(s1[1]);

        // 청소기 방향 dir
        idx = Integer.parseInt(s1[2]);

        for(int i = 0; i < N; i++) {
            String[] row = reader.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                int w = Integer.parseInt(row[j]);
                if(w == 1) {
                    wall[i][j] = true;
                }
                room[i][j] = w;
            }
        }



        // 청소한 칸의 수
        int cnt = 0;


        // 청소되지 않은 빈 칸이 없고, 후진했을 때 벽인 경우 종료
        while(true) {
            // 현재 칸이 청소되지 않은 경우
            if(room[r][c] == 0) {
                room[r][c] = 1;
                // 청소한 칸의 개수 1 증가
                cnt++;
            }
            // 청소되지 않은 빈 칸이 없는 경우
            else if(!allDirCheck(r,c)) {
                // 후진했을 때(r,c 이동함), 벽인 경우
                if(!backMove(dir[idx])) break;
            }
            // 청소되지 않은 빈 칸이 있는 경우
            else {
                // 전방에 청소되지 않은 빈칸이 있을 때 까지 반시계 방향으로 회전, 그리고 전진
                // 1. 전방에 청소되지 않은 빈칸이 있는지 확인
                // 반시계 회전 후 true면 전진
                idx = (idx - 1 + 4) % 4;
                if(frontDirCheck(r, c, dir[idx])) {
                    frontMove(dir[idx]);
                }
            }

        }

        System.out.println(cnt);
    }


    // 4방향에 청소되지 않은 빈 칸이 있는지 체크
    // 4방향에 청소되지 않은 빈 칸이 있으면 true, 없으면 false
    public static boolean allDirCheck(int x, int y) {
        int tempX = x;
        int tempY = y;

        for(int i = 0; i < 4; i++) {
            int nx = tempX + dx[i];
            int ny = tempY + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(room[nx][ny] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // 전방향에 청소되지 않은 빈 칸이 있는지 체크
    // 전방향에 청소되지 않은 빈 칸이 있으면 true, 없으면 false
    public static boolean frontDirCheck(int x, int y, int dir) {
        int tempX = x;
        int tempY = y;

        switch(dir) {
            // 북
            case 0:
                tempX += dx[0];
                tempY += dy[0];
                break;
            case 1:
                tempX += dx[1];
                tempY += dy[1];
                break;
            case 2:
                tempX += dx[2];
                tempY += dy[2];
                break;
            case 3:
                tempX += dx[3];
                tempY += dy[3];
                break;
        }
        // 청소되지 않은 빈 칸인 경우 true 반환
        return room[tempX][tempY] == 0;
    }

    // 현재 방향에 대해 전진
    // 전진 가능하면 true, 전진할 수 없다면 false
    public static boolean frontMove(int dir) {
        //dir : 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
        // d : 북, 동, 남, 서
        switch(dir) {
            // 북
            case 0:
                r += dx[0];
                c += dy[0];
                break;
            case 1:
                r += dx[1];
                c += dy[1];
                break;
            case 2:
                r += dx[2];
                c += dy[2];
                break;
            case 3:
                r += dx[3];
                c += dy[3];
                break;
        }

        return !wall[r][c];
    }

    // 현재 방향에 대해 후진
    // 후진 가능하면 true, 후진할 수 없다면 false
    public static boolean backMove(int dir) {

        //dir : 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
        // d : 북, 동, 남, 서
        switch(dir) {
            // 북
            case 0:
                r += dx[2];
                c += dy[2];
                break;
            case 1:
                r += dx[3];
                c += dy[3];
                break;
            case 2:
                r += dx[0];
                c += dy[0];
                break;
            case 3:
                r += dx[1];
                c += dy[1];
                break;
        }

        return !wall[r][c];
    }
}
