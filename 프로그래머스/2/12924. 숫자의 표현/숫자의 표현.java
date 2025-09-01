class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            if(sum(n, i)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public boolean sum(int n, int num) {
        int result = 0;
        for(int i = num; i <= n; i++) {
            result += i;
            if(result > n) {
                return false;
            } else if(result == n) {
                return true;
            }
        }
        return false;
    }
}