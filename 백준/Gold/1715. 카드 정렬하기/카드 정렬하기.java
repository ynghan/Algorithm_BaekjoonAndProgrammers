import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> cardStacks = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            cardStacks.offer(num);
        }

        int sum = 0;

        while (cardStacks.size() > 1) {
            int min1 = cardStacks.poll();
            int min2 = cardStacks.poll();
            int mergeSum = min1 + min2;
            sum += mergeSum;
            cardStacks.offer(mergeSum);
        }

        System.out.println(sum);
    }
}
