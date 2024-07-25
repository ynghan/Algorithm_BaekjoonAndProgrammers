import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        
        // 우선순위 큐: 절댓값을 기준으로 정렬
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b; // 절댓값이 같으면, 작은 수를 우선
            }
            return Math.abs(a) - Math.abs(b);
        });

        for(int i = 0; i < N; i++) {
            int j = Integer.parseInt(reader.readLine());
            if (j != 0) {
                priorityQueue.offer(j); // 큐에 추가
            }
            else {
                if(priorityQueue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(priorityQueue.poll()); // 절댓값이 가장 작은 수 출력 및 제거
                }
            }
        }
    }
}