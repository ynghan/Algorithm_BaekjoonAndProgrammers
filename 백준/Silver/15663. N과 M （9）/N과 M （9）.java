import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static int N;
  static int M;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    N = Integer.parseInt(s[0]);
    M = Integer.parseInt(s[1]);

    int[] arr = new int[N];
    int[] output = new int[M];
    boolean[] visited = new boolean[N];
    String[] s1 = br.readLine().split(" ");
    for(int i = 0; i< N; i++) {
      arr[i] = Integer.parseInt(s1[i]);
    }
    Arrays.sort(arr);

    dfs(arr, output, visited, 0);
    System.out.print(sb.toString());
  }

  public static void dfs(int[] arr, int[] output, boolean[] visited, int depth) {
    Set<Integer> set = new HashSet<>();
    if(output.length == depth) {
      for (int i : output) sb.append(i).append(" ");
      sb.append("\n");
      return;
    }
      
    for(int i = 0; i < arr.length; i++) {
      if(!visited[i] && !set.contains(arr[i])) {
        visited[i] = true;
        output[depth] = arr[i];
        set.add(arr[i]);
        dfs(arr, output, visited,depth + 1);
        visited[i] = false;
      }
    }
  }
}
