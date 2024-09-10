
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static class Apple {
        int x;
        int y;

        public Apple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class DirChange {
        int time;
        char dir;

        public DirChange(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int K = Integer.parseInt(reader.readLine());
        List<Apple> apples = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            String[] s = reader.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            apples.add(new Apple(x, y));
        }

        // 방향 전환 정보
        int L = Integer.parseInt(reader.readLine());
        List<DirChange> dirChanges = new ArrayList<>();
        for (int l = 0; l < L; l++) {
            String[] s = reader.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            char c = s[1].charAt(0); // 여기서 수정: s[1]에서 방향을 가져와야 합니다.
            dirChanges.add(new DirChange(t, c));
        }

        // 게임 로직
        Deque<int[]> snake = new LinkedList<>(); // 뱀의 위치를 큐로 관리
        snake.addFirst(new int[]{1, 1}); // 뱀의 초기 위치 (1, 1)

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 오른쪽, 아래, 왼쪽, 위 방향
        int direction = 0; // 초기 방향 (0: 오른쪽)
        boolean[][] board = new boolean[N + 1][N + 1]; // 보드 초기화
        for (Apple apple : apples) {
            board[apple.x][apple.y] = true; // 사과 위치 표시
        }

        int time = 0;
        int changeIndex = 0;

        while (true) {
            time++;
            // 뱀의 머리 위치 계산
            int[] head = snake.peekFirst();
            int newX = head[0] + directions[direction][0];
            int newY = head[1] + directions[direction][1];

            // 벽이나 자기 자신과의 충돌 체크
            if (newX < 1 || newX > N || newY < 1 || newY > N || isSnakeBody(snake, newX, newY)) {
                break; // 게임 종료
            }

            // 뱀의 머리 위치 추가
            snake.addFirst(new int[]{newX, newY});

            // 사과가 있는지 체크
            if (board[newX][newY]) {
                board[newX][newY] = false; // 사과 제거
            } else {
                // 꼬리 위치 제거
                snake.removeLast();
            }

            // 방향 전환 체크
            if (changeIndex < dirChanges.size() && dirChanges.get(changeIndex).time == time) {
                if (dirChanges.get(changeIndex).dir == 'L') {
                    direction = (direction + 3) % 4; // 왼쪽으로 90도 회전
                } else {
                    direction = (direction + 1) % 4; // 오른쪽으로 90도 회전
                }
                changeIndex++;
            }
        }

        System.out.println(time); // 게임 종료 시각 출력
    }

    // 뱀의 몸에 해당 위치가 있는지 체크하는 메서드
    private static boolean isSnakeBody(Deque<int[]> snake, int x, int y) {
        for (int[] body : snake) {
            if (body[0] == x && body[1] == y) {
                return true; // 뱀의 몸에 충돌
            }
        }
        return false; // 충돌하지 않음
    }
}
