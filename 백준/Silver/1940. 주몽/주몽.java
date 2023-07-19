import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());

        int[] num = new int[N+1];
        int[] visited = new int[N+1];

        int sum = 0;
        int start_index = 1;
        int end_index = 2;

        st = new StringTokenizer(bf.readLine());

        for(int i = 1 ; i < N+1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        while(start_index != N && end_index < N + 1) {

            sum = num[start_index] + num[end_index];

            if(start_index == end_index) {
                end_index++;
            }
            else if(visited[end_index] == 1) {
                end_index++;
            }
            else if( visited[start_index] == 1) {
                start_index++;
            }
            else if(sum == M) {
                count++;

                visited[start_index] = 1;
                visited[end_index] = 1;

                start_index++;
                end_index = start_index;
            }
            else if(sum != M) {

                if(end_index == N) {
                    start_index++;
                    end_index = start_index;
                } else {
                    end_index++;
                }
            }
        }

        System.out.println(count);
    }
}
