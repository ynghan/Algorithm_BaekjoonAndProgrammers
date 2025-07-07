import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int s : scoville) {
            pQ.offer(s);
        }
        
        // 모든 요소가 K 이상이라면 종료
        while(true) {
            if(pQ.peek() != null && pQ.peek() < K) {
                Integer lowest1 = pQ.poll();
                if(pQ.peek() != null) {
                  Integer lowest2 = pQ.poll();
                  pQ.offer(lowest1 + 2 * lowest2);
                  answer++;
                } else {
                  return -1;
                }
              } else {
                break;
            }
        }
        return answer;
    }
}