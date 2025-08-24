import java.util.*;
class Solution {
    public int solution(String dartResult) {
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.remove(list.size()-1);
        // System.out.println(list.get(0));
        // return 0;
        int answer = 0;
        List<Number> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int size = -1;
        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            // System.out.print(c + " ");
            if(c >= '0' && c <= '9') {
                sb.append(c);    
            }
            else if(c == 'S' || c == 'D' || c == 'T') {
                int num = Integer.parseInt(sb.toString());
                int p = c == 'S' ? 1 : c == 'D'? 2 : 3;
                double cal = Math.pow(num, p);
                Number number = new Number((int)cal);
                list.add(number);
                size++;
                sb = new StringBuilder();
            }
            else if(c == '*') {
                Number number = list.get(size);
                number.status = 1;
                number.value *= 2;
                if(size-1 >= 0) {
                    Number n = list.get(size-1);
                    n.value *= 2;
                }
            }
            else {
                Number number = list.get(size);
                number.status = 2;
                number.value *= -1;
            }
        }
        for(Number num : list) {
            answer += num.value;
        }
        return answer;
    }
    
    public class Number {
        int status;
        int value;
        
        public Number(int value) {
            this.value = value;
            this.status = 0;
        }
    }
}