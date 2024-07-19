import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int M = array[1];
        int[][] board = new int[N][M];


        for(int i = 0; i < N; i++) {
            String[] str = reader.readLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < M; j++) {
                board[i][j] = arr[j];
            }
        }

        for(int i = 0; i < N; i++) {
            String[] str = reader.readLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < M; j++) {
                board[i][j] += arr[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}