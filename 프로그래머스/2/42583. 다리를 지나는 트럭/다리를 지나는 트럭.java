import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<int[]> list = new LinkedList<>();
        int time = 0;

        int index = 0;
        int out = 0;
        while(truck_weights.length > out) {
          time++;

          // 트럭들 시간 증가
          for (int[] truck : list) truck[1]++;

          // 다리 끝난 트럭 제거
          if (!list.isEmpty() && list.peek()[1] > bridge_length) {
            list.poll();
            out++;
          }

          // 다리 위 트럭 무게 계산
          int sum = 0;
          for (int[] truck : list) sum += truck[0];

          // 트럭 수 && 다리 위 무게 + 현재 트럭 무게 < 제한된 무게 조건걸기
          if(index < truck_weights.length && sum + truck_weights[index] <= weight) {
            list.add(new int[]{truck_weights[index++], 1});
          }
        }
        answer = time;
        return answer;
    }
}