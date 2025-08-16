import java.util.*;

class Solution {
    public boolean solution(int x) {
        int div = 0;
        int val = x;
        while(x > 0) {
            div += x % 10;
            x /= 10;
        }
        
        return val % div == 0 ? true : false;
    }
}