class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                sb.append(c);
                start = true;
            } else {
                if(Character.isLetter(c) && start) {
                    sb.append(Character.toUpperCase(c));
                    start = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                    start = false;
                }
            }
        }
        
        return sb.toString();
    }
}