import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int N;
  static int M;

  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    N = Integer.parseInt(s[0]);
    M = Integer.parseInt(s[1]);

    arr = new int[N];
    int[] output = new int[M];
    boolean[] visited = new boolean[N];

    String[] s1 = br.readLine().split(" ");
    for(int i = 0; i< N; i++) {
      arr[i] = Integer.parseInt(s1[i]);
    }
    Arrays.sort(arr);

    dfs(output, visited, 0);
    System.out.print(sb.toString());
  }

  public static void dfs(int[] output, boolean[] visited, int depth) {

    if(output.length == depth) {
      for(int i : output) sb.append(i).append(" ");
      sb.append("\n");
      return;
    }

    for(int i = 0; i < arr.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = arr[i];
        dfs(output, visited, depth + 1);
        visited[i] = false;
      }
    }
  }
}
