import java.util.*;


class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack stack = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (')' == s.charAt(i) && stack.size() > 0) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.size() == 0 ? true : false;
    }
}