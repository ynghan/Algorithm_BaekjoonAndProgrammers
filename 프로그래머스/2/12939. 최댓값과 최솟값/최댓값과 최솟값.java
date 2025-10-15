import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String str : strArr) {
            int i = Integer.valueOf(str);
            if(max < i) max = i;
            if(min > i) min = i;
        }
        
        return min + " " + max;
    }
}