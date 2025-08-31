import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        
        int[] num = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(num);
        answer += "" + num[0];
        answer += " " + num[num.length-1];
        return answer;
    }
}