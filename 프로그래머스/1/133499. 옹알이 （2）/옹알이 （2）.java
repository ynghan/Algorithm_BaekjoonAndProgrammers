import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        for(int i = 0; i < babbling.length; i++) {
            String bab = babbling[i];
            boolean start = true;
            int idx = -1;
            while(start) {
                start = false;
                
                for(int j = 0; j < arr.length; j++) {
                    if(bab.startsWith(arr[j]) && idx != j) {
                        bab = bab.substring(arr[j].length(), bab.length());
                        start = true;
                        idx = j;
                        break;
                    }
                }
            }
            if(bab.isEmpty()) {
               answer++; 
            }
        }
        
        return answer;
    }
}