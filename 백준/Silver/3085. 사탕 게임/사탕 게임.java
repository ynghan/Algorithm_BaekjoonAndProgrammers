import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        char[][] board = new char[N][N];
        int result = 0;

        // 입력을 char 2차원 배열로 받기
        for(int i = 0; i < N; i++) {
            String string = reader.readLine();
            for(int j = 0; j < N; j++) {
                char c = string.charAt(j);
                board[i][j] = c;
            }
        }

        // 현재 배열에 대한 최대 연속 값 찾기
        int max = maxCount(board);

        // 현재 배열의 max 값이 이미 최대이면 반환
        if(max == N) {
            System.out.println(max);
            return;
        }

        // 아니면 바꿔보면서 찾기 : 2차원 배열의 모든 원소를 브루트 포스로 탐색하면서 dx, dy로 바꿔가면서 최대 연속 값을 찾아보자.

        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, -1, 0, 1};


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++) {
                    if (i + dx[k] < N && i + dx[k] >= 0 && j + dy[k] >= 0 && j + dy[k] < N ) {
                        if(board[i][j] != board[i+dx[k]][j+dy[k]]) {
                            char temp = board[i][j];
                            board[i][j] = board[i+dx[k]][j+dy[k]];
                            board[i+dx[k]][j+dy[k]] = temp;
                        }
                        int curr = maxCount(board);
                        if( max  < curr ) {
                            max = curr;
                        }

                        char temp = board[i][j];
                        board[i][j] = board[i+dx[k]][j+dy[k]];
                        board[i+dx[k]][j+dy[k]] = temp;

                    }
                }
            }
        }

        System.out.println(max);
    }


    public static int maxCount(char[][] board) {
        if( board == null || board.length == 0) {
            return 0;
        }

        int row_max = 0;
        int col_max = 0;

        // 행의 연속 값 찾기
        for(int i = 0; i < board.length; i++) {
            int count = 1;
            char current = board[i][0];
            for(int j = 1; j < board[i].length; j++) {
                if(current == board[i][j]) {
                    current = board[i][j];
                    count++;

                }

                else {
                    current = board[i][j];
                    count = 1;
                }

                if(row_max < count) {
                    row_max = count;
                }
            }
        }


        // 열의 연속 값 찾기
        for(int i = 0; i < board.length; i++) {
            int count = 1;
            char current = board[0][i];
            for(int j = 1; j < board.length; j++) {
                if(current == board[j][i]) {
                    current = board[j][i];
                    count++;

                }

                else {
                    current = board[j][i];
                    count = 1;
                }

                if(col_max < count) {
                    col_max = count;
                }
            }
        }

        return Math.max(row_max, col_max);
    }
}