import java.util.*;

class Solution {
    public int solution(int n) {
        if(n == 2) return 1;
        if(n == 3 || n == 4) return 2;

        int answer = 0;
        Set<Integer> sosu = new HashSet<>();
        sosu.add(2);
        sosu.add(3);
        for(int i = 5; i <= n; i++) {
            boolean isSosu = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isSosu = false;
                    break;
                }
            }
            if(isSosu) sosu.add(i);
        }
        return sosu.size();
    }
}