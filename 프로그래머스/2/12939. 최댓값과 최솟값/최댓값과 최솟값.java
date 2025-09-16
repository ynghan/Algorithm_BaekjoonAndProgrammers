import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        
        int[] num = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(num);
        return num[0] + " " + num[num.length-1];
    }
}