import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);
      
    int[] arr = new int[N];
    boolean[] visited = new boolean[N];
    // 초기화
    for(int i = 0; i < N; i++) {
      arr[i] = i + 1;
    }
    combination(arr, new int[M], 0, 0);

  }

  public static void combination(int[] arr, int[] output, int start, int depth) {

    if(output.length == depth) {
      for (int i : output) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    }

    for(int i = start; i < arr.length; i++) {
      output[depth] = arr[i];
      combination(arr, output,i + 1, depth + 1);
    }
  }
}