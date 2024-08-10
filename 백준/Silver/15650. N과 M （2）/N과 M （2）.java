import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);

    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            int temp = arr[0];
            for(int i = 1 ; i < M; i++) {
                if(temp > arr[i]) {
                    return;
                }
                else {
                    temp = arr[i];
                }
            }
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}