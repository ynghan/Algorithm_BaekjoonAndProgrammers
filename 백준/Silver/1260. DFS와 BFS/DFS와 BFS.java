import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static StringTokenizer st;
  static StringBuilder sb;
  static List<Integer>[] arrList;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();
    // 노드 수
    int node = Integer.parseInt(st.nextToken());
    // 간선 수
    int edge = Integer.parseInt(st.nextToken());
    // 시작 노드
    int start = Integer.parseInt(st.nextToken());

    arrList = new ArrayList[node + 1];
    visited = new boolean[node + 1];

    for(int i = 1; i <= node; i++) {
      arrList[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i < edge; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arrList[a].add(b);
      arrList[b].add(a);
    }

    for(int i = 1; i <= node; i++) {
      Collections.sort(arrList[i]);
    }

    dfs(start);
    sb.append("\n");

    visited = new boolean[node + 1];
    bfs(start);

    System.out.println(sb.toString());

  }


  public static  void dfs(int startNode) {
    if(!visited[startNode]) {
      visited[startNode] = true;
      sb.append(startNode).append(" ");
    }

    for (int n : arrList[startNode]) {
      if(!visited[n]) {
        dfs(n);
      }
    }
  }

  public static void bfs(int startNode) {
    Queue<Integer> queue = new LinkedList<>();
    visited[startNode] = true;
    queue.offer(startNode);

    while(!queue.isEmpty()) {
      int current = queue.poll();
      sb.append(current).append(" ");

      for (int neighbor : arrList[current]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }
  }
}
