
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] s = reader.readLine().split(" ");
        // 행
        int N = Integer.parseInt(s[0]);
        // 열
        int M = Integer.parseInt(s[1]);



        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        // A 값 넣기
        for(int i = 0; i < N; i++) {
            String string = reader.readLine();
            char[] charArray = string.toCharArray();
            for(int j = 0; j < M; j++) {
                A[i][j] = charArray[j] - '0';
            }
        }

        // B 값 넣기
        for(int i = 0; i < N; i++) {
            String string = reader.readLine();
            char[] charArray = string.toCharArray();
            for(int j = 0; j < M; j++) {
                B[i][j] = charArray[j] - '0';
            }
        }

        if((N < 3 || M < 3) && !(Arrays.deepEquals(A,B))) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        for(int i = 0; i < N - 2; i++) {
            for(int j = 0; j < M - 2; j++) {
                if(A[i][j] != B[i][j]) {
                    count++;
                    for(int k = i; k < i + 3; k++) {
                        for(int r = j; r < j + 3; r++) {
                            A[k][r] = 1 - A[k][r];
                        }
                    }
                }
            }
        }


        if(Arrays.deepEquals(A,B)) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }
}
