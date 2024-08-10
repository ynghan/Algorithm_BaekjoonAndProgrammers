import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[] result = new int[] {0,0};



        count(arr, 0,0, N, result);

        for (int i : result) {
            System.out.println(i);
        }

    }

    public static void count(int[][] arr, int x, int  y, int size, int[] result) {
        if(size == 1) {
            result[arr[x][y]]++;
        }

        else if(equal(arr, x, y, size)) {
            result[arr[x][y]]++;
        }
        else {
            count(arr, x, y, size/2, result);
            count(arr, x, y+size/2, size/2, result);
            count(arr, x+size/2, y, size/2, result);
            count(arr, x+size/2, y+size/2, size/2, result);
        }
    }

    public static boolean equal(int[][] arr, int x, int y, int size) {
        int num = arr[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
