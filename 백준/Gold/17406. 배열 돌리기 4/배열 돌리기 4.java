import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] rotate;
    static List<List<Integer>> permutations;
    static List<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        // 행
        int N = Integer.parseInt(s[0]);
        // 열
        int M = Integer.parseInt(s[1]);
        // 회전 연산의 개수
        int K = Integer.parseInt(s[2]);

        // 행렬 초기화
        int[][] board = new int[N+1][M+1];
        // 회전 연산 배열 초기화
        rotate = new int[K][3];

        // permutations와 results 초기화
        permutations = new ArrayList<>();
        results = new ArrayList<>();


        // 배열 정보 입력받기
        for(int i = 1; i <= N; i++) {
            String[] row = reader.readLine().split(" ");
            for(int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(row[j-1]);
            }
        }

        // 회전 연산 입력받기
        for(int i = 0; i < K; i++) {
            String[] s1 = reader.readLine().split(" ");
            rotate[i][0] = Integer.parseInt(s1[0]); // r
            rotate[i][1] = Integer.parseInt(s1[1]); // c
            rotate[i][2] = Integer.parseInt(s1[2]); // s
        }

        // 처음 board -> 회전 연산 적용 (K번 반복) -> visited를 이용한 순열 적용 -> 백트래킹하면 안됨
        int[] arr = new int[K];
        for(int k = 0 ; k < arr.length; k++) {
            arr[k] = k;
        }

        generatePermutations(arr, 0, permutations);

        for (List<Integer> permutation : permutations) {
            int[][] tempBoard = copyBoard(board);
            int result = rotate(tempBoard, permutation);
            results.add(result);
        }

        System.out.println(Collections.min(results));
    }

    // 순열 생성하기
    public static void generatePermutations(int[] rotate, int start, List<List<Integer>> permutations) {
        if(start == rotate.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : rotate) {
                perm.add(num);
            }
            permutations.add(perm);
            return;
        }

        for(int i = start; i < rotate.length; i++) {
            swap(rotate, start, i);
            generatePermutations(rotate, start + 1, permutations);
            swap(rotate, start, i);
        }
    }

    public static void swap(int[] rotate, int i, int j) {
        int temp = rotate[i];
        rotate[i] = rotate[j];
        rotate[j] = temp;
    }

    // 회전시키기
    public static int rotate(int[][] board, List<Integer> permutation) {

        for (Integer idx : permutation) {
            int r = rotate[idx][0];
            int c = rotate[idx][1];
            int s = rotate[idx][2];

            for (int i = 0; i < s; i++) {
                // 사각형의 네 꼭짓점 좌표
                int up_left_x = r - s + i;
                int up_left_y = c - s + i;
                int down_right_x = r + s - i;
                int down_right_y = c + s - i;

                // 처음 수 저장하기
                int temp = board[up_left_x][up_left_y];

                // 왼쪽 세로 회전
                for (int row = up_left_x; row < down_right_x; row++) {
                    board[row][up_left_y] = board[row + 1][up_left_y];
                }
                // 아래쪽 가로 회전
                for (int col = up_left_y; col < down_right_y; col++) {
                    board[down_right_x][col] = board[down_right_x][col + 1];
                }
                // 오른쪽 세로 회전
                for (int row = down_right_x; row > up_left_x; row--) {
                    board[row][down_right_y] = board[row - 1][down_right_y];
                }
                // 위쪽 가로 회전
                for (int col = down_right_y; col > up_left_y + 1; col--) {
                    board[up_left_x][col] = board[up_left_x][col - 1];
                }

                board[up_left_x][up_left_y + 1] = temp;
            }
        }

        // 각 행의 최소값을 구하여 합산
        int minSum = Integer.MAX_VALUE;
        for (int row = 1; row <= board.length - 1; row++) {
            int sum = 0;
            for (int col = 1; col <= board[row].length - 1; col++) {
                sum += board[row][col];
            }
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }

    public static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

}
