import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] split = reader.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        solveSudoku();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku()) {
                                return true;
                            }
                            board[i][j] = 0; // 백트래킹
                        }
                    }
                    return false; // 모든 숫자가 유효하지 않으면 false 반환
                }
            }
        }
        return true; // 모든 셀이 채워졌다면 true 반환
    }

    public static boolean isValid(int row, int col, int num) {
        // 행 검사
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // 3x3 박스 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
