import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        Queue<Integer> q = new PriorityQueue<>();
        Queue<Integer> qReverse = new PriorityQueue<>(Collections.reverseOrder());

        for (String o : operations) {
          String[] s = o.split(" ");
          if(s[0].equals("I")) {
            int i = Integer.parseInt(s[1]);
            q.add(i);
            qReverse.add(i);
          } else if(s[0].equals("D") && s[1].equals("1")){ // 최대값 삭제
            if(!qReverse.isEmpty()) {
              int max = qReverse.poll();
              q.remove(max);
            }
          } else if(s[0].equals("D") && s[1].equals("-1")){ // 최소값 삭제
            if(!q.isEmpty()) {
              int min = q.poll();
              qReverse.remove(min);
            }
          }
        }

        if(!q.isEmpty()) {
            answer[1] = q.peek();
        }
        if(!qReverse.isEmpty()) {
            answer[0] = qReverse.peek();
        }
        return answer;
    }
}