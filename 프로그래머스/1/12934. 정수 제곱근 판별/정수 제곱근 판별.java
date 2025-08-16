import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        for(int i = 1; i <= Math.pow(n, 0.5) ; i++) {
            if(Math.pow(i,2) == n) return (long) Math.pow(i+1,2);
        }
        
        return -1;
    }
}