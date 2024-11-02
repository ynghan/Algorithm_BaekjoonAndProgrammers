import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N; // 도시의 개수
    static int M; // 도로의 개수
    static int K; // 최단 거리
    static int X; // 출발 도시의 번호
    static List<List<Node>> graph;
    static int[] length;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        X = Integer.parseInt(s[3]);

        graph = new ArrayList<>();
        length = new int[N+1];
        visited = new boolean[N+1];

        // 그래프 초기화
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            length[i] = -1;
        }

        // 도로 정보 입력
        for(int i = 0; i < M; i++) {
            String[] s1 = reader.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end = Integer.parseInt(s1[1]);
            graph.get(start).add(new Node(end, 1));
        }

        // BFS 수행
        Queue<Node> queue = new LinkedList<>();
        length[X] = 0;
        queue.add(new Node(X, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(Node next : graph.get(current.vertex)) {
                if(length[next.vertex] == -1) {
                    length[next.vertex] = current.cost + 1;
                    queue.add(new Node(next.vertex, current.cost + 1));
                }
            }
        }

        // 결과 출력
        boolean result = false;
        for(int i = 1; i <= N; i++) {
            if(length[i] == K) {
                System.out.println(i);
                result = true;
            }
        }

        if(!result) {
            System.out.println(-1);
        }
    }

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}