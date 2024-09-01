import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int V;
    static int[] parents;

    public static void make() {
        parents = new int[V];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if(parents[a]<0) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a-1);
        int bRoot = findSet(b-1);

        if(aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot]; // 집합 크기관리
        parents[bRoot] = aRoot;
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        // 정점 수
        V = Integer.parseInt(s[0]);
        // 간선 수
        int E = Integer.parseInt(s[1]);

        Edge[] edges = new Edge[E];

        // 간선 수만큼 반복문
        for(int i = 0; i < E; i++) {
            String[] e = reader.readLine().split(" ");
            edges[i] = new Edge(Integer.parseInt(e[0]), Integer.parseInt(e[1]), Integer.parseInt(e[2]));
        }

        // 팀 배열 생성
        make();
        // 간선 가중치 기준 오름차순 정령
        Arrays.sort(edges);

        int cnt = 0, cost = 0;
        for (Edge edge : edges) {
            if(union(edge.start, edge.end)) {
                cost += edge.weight;
                if(++cnt == V-1) break; // 최소신장트리 완성!!
            }
        }

        System.out.println(cost);
    }

    static class Edge implements Comparable<Edge>{

        int start, end, weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

}
