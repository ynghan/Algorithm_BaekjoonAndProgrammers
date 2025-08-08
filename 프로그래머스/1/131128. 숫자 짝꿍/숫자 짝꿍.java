import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        char[] charX = X.toCharArray();
        char[] charY = Y.toCharArray();
        
        StringBuilder answer = new StringBuilder();
        
        Arrays.sort(charX);
        Arrays.sort(charY);
        
        int idxX = charX.length - 1;
        int idxY = charY.length - 1;
        
        while(idxX >= 0 && idxY >= 0) {
            
            if(charX[idxX] > charY[idxY]) {
                idxX--;
            } else if(charX[idxX] < charY[idxY]) {
                idxY--;
            } else {
                answer.append(charX[idxX]);
                idxX--;
                idxY--;
            }
        }
        
        // 공통으로 나타나는 정수가 없을 경우
        if (answer.length() == 0) {
            return "-1";
        }

        // 정수 k가 0으로만 구성되어 있을 경우
        if (answer.toString().matches("0+")) {
            return "0";
        }
        
        return answer.toString();
    }
}