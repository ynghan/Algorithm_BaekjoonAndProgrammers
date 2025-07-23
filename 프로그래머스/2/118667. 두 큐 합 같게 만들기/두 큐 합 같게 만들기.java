import java.util.*;

public class Solution {
    public static int solution(int[] q1, int[] q2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i : q1) queue1.add(i);
        for (int i : q2) queue2.add(i);

        long sum1 = Arrays.stream(q1).asLongStream().sum();
        long sum2 = Arrays.stream(q2).asLongStream().sum();

        int count = 0;
        int max = (q1.length + q2.length) * 2;

        while (count <= max) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {
                int val = queue1.poll();
                sum1 -= val;
                sum2 += val;
                queue2.add(val);
            } else {
                int val = queue2.poll();
                sum2 -= val;
                sum1 += val;
                queue1.add(val);
            }
            count++;
        }

        return -1; // 종료 조건이 안되는 경우
    }
}