
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static class Node {
        int num, len;
        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }
    
    static List<Node> list[];
    static boolean visit[];
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        list = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, len));
            list[to].add(new Node(from, len));
        }

        ans = 0;
        visit = new boolean[N + 1];
        dfs(1); // 임의의 노드(1번 노드)에서 DFS 시작

        System.out.println(ans);
    }

    private static int dfs(int num) {
        visit[num] = true;
        int max1 = 0, max2 = 0;

        for(Node node : list[num]) {
            if (!visit[node.num]) {
                int length = dfs(node.num) + node.len;

                if (length > max1) {
                    max2 = max1;
                    max1 = length;
                } else if (length > max2) {
                    max2 = length;
                }
            }
        }

        ans = Math.max(ans, max1 + max2);
        return max1;
    }
}
