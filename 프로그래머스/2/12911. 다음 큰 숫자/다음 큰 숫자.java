class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        int count = 0; // 1의 개수
        int idx = -1; // 반전될 인덱스
        
        while(n > 0) {
            if(n % 2 == 1) {
                count++;
                sb.append(1);
            } else {
                sb.append(0);
            }
            n /= 2;
        }
        String s = sb.toString();
        if(s.length() == 1) {
            return 2;
        }
        // 0111001
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '1' && s.charAt(i+1) == '0') {
                idx = i;
                break;
            } else if(s.charAt(i) == '1') {
                left++;
            }
        }
        // System.out.println("idx : " + idx);
        if(idx == -1) {
            idx = s.length() - 1;
        }
        StringBuilder newSB = new StringBuilder();
        for(int i = 0; i < idx; i++) {
            if( left > i) { 
                newSB.append(1);
            } else {
                newSB.append(0);
            }
        }
        newSB.append("01");
        if(sb.length() > idx+1) {
            newSB.append(s.substring(idx+2, s.length()));
        }
        
        // System.out.println(s);
        // System.out.println(newSB.toString());
        
        int cnt = 1;
        for(int i = 0; i < newSB.toString().length(); i++) {
            if(newSB.charAt(i) == '1') {
               answer += 1 * cnt; 
            }
            cnt *= 2;
        }
        return answer;
    }
}