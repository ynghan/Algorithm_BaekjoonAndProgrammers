import java.util.*;

class Solution {
    public boolean solution(String s) {
        Deque<X> queue = new ArrayDeque<>();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(') {
                queue.add(new X(c[i]));   
            } else {
                if(queue.peek() != null) {
                    queue.poll();
                } else {
                    return false;
                }
            }
        }
        return queue.isEmpty() ? true : false;
    }
}

class X {
    char c;
    
    public X(char c) {
        this.c = c;
    }
}