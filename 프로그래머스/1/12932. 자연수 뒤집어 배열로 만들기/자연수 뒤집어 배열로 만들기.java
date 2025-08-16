import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        
        while(n > 0) {
            list.add(n%10);
            n /= 10;
        }
        
        return list.stream().mapToInt(Long::intValue).toArray();
    }
}