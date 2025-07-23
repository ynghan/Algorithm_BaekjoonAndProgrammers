
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        
        int prev = (100 - progresses[0]) % speeds[0] == 0 ? (100 - progresses[0]) / speeds[0] : (100 - progresses[0]) / speeds[0] + 1;
        int val = 1;
        for(int i = 1; i < progresses.length; i++) {
            
            int time = (100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            
            if(time <= prev) { 
                val++;
            } else {
                answer.add(val);
                prev = time;
                val = 1;
            }
        }
        answer.add(val);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}