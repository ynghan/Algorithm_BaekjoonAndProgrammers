import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] smaller;
    static List<Integer>[] larger;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());

        // 크기 비교 입력 받기
        smaller = new ArrayList[N + 1];
        larger = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            smaller[i] = new ArrayList<>();
            larger[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s = reader.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            larger[a].add(b);
            smaller[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            int unknownCount = countUnknown(i);
            System.out.println(unknownCount);
        }
    }

    public static int countUnknown(int k) {
        boolean[] visited = new boolean[N + 1];
        int count = 0;

        // k보다 큰 물건 수 찾기
        count += bfs(k, larger, visited);

        // k보다 작은 물건 수 찾기
        Arrays.fill(visited, false); // visited 배열 초기화
        count += bfs(k, smaller, visited);

        return N - 1 - count; // k를 제외하고 알 수 없는 물건의 수
    }

    public static int bfs(int start, List<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}
