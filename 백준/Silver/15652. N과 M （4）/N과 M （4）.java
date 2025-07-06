import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);

    int[] arr = new int[N];
    int[] output = new int[M];

    for(int i = 0; i < N; i++) {
      arr[i] = i+1;
    }

    dfs(arr, output, 0, 0);
    System.out.print(sb.toString());
  }


  public static void dfs(int[] arr, int[] output, int depth, int min) {

    if(output.length == depth) {
      for (int i : output) sb.append(i).append(" ");
      sb.append("\n");
      return;
    }

    for(int i = min; i < arr.length; i++) {
      output[depth] = arr[i];
      dfs(arr, output, depth+1, i);
    }
  }
}