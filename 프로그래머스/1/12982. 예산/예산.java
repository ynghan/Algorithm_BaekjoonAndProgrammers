import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d); // 1,2,3,4,5
        for(int i = 0; i < d.length; i++) {
            int add = 0;
            int len = 0;
            for(int j = i; j < d.length; j++) {
                if(add + d[j] <= budget) {
                    add += d[j];
                    len++;
                } else {
                    break;
                }
            }
            if(answer < len) answer = len;
        }        
        
        return answer;
    }
}