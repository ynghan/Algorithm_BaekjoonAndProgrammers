import java.util.*;
import java.math.*;

class Solution {
    public int solution(String number) {
        String number1 = "123";
        BigInteger answer = new BigInteger(number);
        System.out.println(answer);
        BigInteger remain = new BigInteger("9");
        answer = answer.remainder(remain);
        
        int i = answer.intValue();
        return i;
    }
}