
import static java.lang.Math.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        int[] num = {a,b,c};
        
        int two_dup = 0;
        int three_dup = 0;

        for (int i : num) {
            answer += i;
        }

        if(num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) {
            for(int i : num) {
                two_dup += (int) (pow(i,2));
            }
            answer *= two_dup;
            if(num[0] == num[1] && num[1] == num[2]) {
                for(int i : num) {
                    three_dup += (int) (pow(i,3));
                }
                answer *= three_dup;
            }
        }
        
        
        return answer;
    }
}