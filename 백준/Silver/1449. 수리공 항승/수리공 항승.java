import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static int L;
    static int[] pos;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        // 물이 새는 곳의 개수
        N = Integer.parseInt(s[0]);
        // 테이프의 길이
        L = Integer.parseInt(s[1]);

        pos = new int[N];
        visited = new boolean[N];

        String[] s1 = reader.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(pos);

        List<Integer> result = new ArrayList<>();


        int answer = 0;
        // 1 2 100 101
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                sequence(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void sequence(int i) {

        visited[i] = true;
        int cur = pos[i++];
        // 구멍 개수 이내
        while(i < N) {
            if(L >= pos[i] - cur + 1) {
                visited[i] = true;
                i++;
            }
            else {
                return;
            }
        }
    }
}
