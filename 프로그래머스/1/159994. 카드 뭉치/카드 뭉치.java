import java.util.*;


class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        ArrayDeque<String> stack1 = new ArrayDeque<>();
        ArrayDeque<String> stack2 = new ArrayDeque<>();
        ArrayDeque<String> stack3 = new ArrayDeque<>();

        for (String s : cards1) {
          stack1.addLast(s);
        }
        for(String s : cards2) {
          stack2.addLast(s);
        }
        for(String s : goal) {
          stack3.addLast(s);
        }

        for (String s : stack3) {
          if(!stack2.isEmpty() && stack2.peekFirst().equals(s)) {
            stack2.pollFirst();
            stack3.pollFirst();
          } else if (!stack1.isEmpty() && stack1.peekFirst().equals(s)){
            stack1.pollFirst();
            stack3.pollFirst();
          } else {
            return "No";
          }
        }
        return "Yes";
    }
}