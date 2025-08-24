class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        while(s.length() > idx) {
            if(idx == s.length() - 1) {
                answer++;
                break;
            }
            char c = s.charAt(idx);
            int equal = 0;
            int diff = 0;
            for(int i = idx; i < s.length(); i++) {
                if(s.charAt(i) == c) {
                    equal++;
                } else {
                    diff++;
                }
                
                if(equal == diff) {
                    idx = i+1;
                    answer++;
                    break;
                }
            }
            
            if(equal != diff) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}