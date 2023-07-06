import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for(int i = 1; i < N + 1; i++)
        {
            arr[i] = i;
        }

        int num;
        int node1;
        int node2;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M ; i++) {

            input = br.readLine();
            st = new StringTokenizer(input);
            num = Integer.parseInt(st.nextToken());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            if(num == 0) {
                union(node1, node2);
            }
            else if (num == 1){
                sb.append((result(node1, node2) ? "YES" : "NO") + "\n");
            }
            else {
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean result(int node1, int node2) {
        int x = find(node1);
        int y = find(node2);

        if(x == y) {
            return true;
        }
        return false;
    }

    public static void union(int node1, int node2) {
        int x = find(node1);
        int y = find(node2);

        if( x != y ) {
            if(x < y) {
                arr[y] = x;
            } else {
                arr[x] = y;
            }
        }
    }

    public static int find(int node) {
        if(node == arr[node]) {
            return node;
        }
        return arr[node] = find(arr[node]);
    }
}
