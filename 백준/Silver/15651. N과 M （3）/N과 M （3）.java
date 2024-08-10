import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new int[M];

        dfs(N, M, 0);
        System.out.print(sb.toString()); // 한 번에 출력
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" "); // StringBuilder에 추가
            }
            sb.append("\n"); // 줄바꿈 추가
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }
}
