import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        for(int i = mats.length - 1; i >= 0; i--) {
            if(dot(mats[i], park)) return mats[i];
        }
        return -1;
    }
    
    public boolean dot(int m, String[][] park) {
        for(int i = 0 ; i <= park.length - m; i++) {
            for(int j = 0; j <= park[0].length - m; j++) {
                if(park[i][j].equals("-1")) {
                    if(start(m, i, j, park)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean start(int m, int i , int j, String[][] park) {
        
        for(int k = i; k < m+i; k++) {
            for(int l = j; l < m+j; l++) {
                if(!park[k][l].equals("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}