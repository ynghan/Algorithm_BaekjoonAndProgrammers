class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        answer = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            int gcd = getGCD(answer, arr[i]);
            answer = (answer * arr[i])/gcd;
        }
        
        return answer;
    }
    
    public static int getGCD(int val1, int val2) {
        if(val1 % val2 == 0) {
            return val2;    
        }
        
        return getGCD(val2, val1 % val2);
    }
}