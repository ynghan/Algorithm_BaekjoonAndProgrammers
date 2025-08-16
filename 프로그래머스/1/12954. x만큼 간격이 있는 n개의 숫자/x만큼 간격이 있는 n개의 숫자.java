import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> answer = new ArrayList<>();
        long count = 0;
        long val = (long) x;
        while(count < n) {
            answer.add((long) val);
            val += x;
            count++;
        }
        
        return answer.stream().mapToLong(Long::longValue).toArray();
    }
}