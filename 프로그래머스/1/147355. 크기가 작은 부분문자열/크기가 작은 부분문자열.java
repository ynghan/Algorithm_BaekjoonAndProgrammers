class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long vP = Long.parseLong(p);
        int lengthT = t.length();
        int lengthP = p.length();
        
        for(int i = 0; i < lengthT - lengthP + 1; i++) {
            if(t.charAt(i) < p.charAt(0)) {
                answer++;
                continue;
            } else {
                long vT = Long.parseLong(t.substring(i, i+lengthP));
                if(vT <= vP) answer++;   
            }
        }
        
        return answer;
    }
}