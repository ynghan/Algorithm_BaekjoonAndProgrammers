import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int idx = score.length-1;
        while(idx >= 0) {
            if(idx-m+1 >= 0) {
                answer += score[idx-m+1]*m;
                idx = idx-m;
            } else {
                break;
            }
        }
        return answer;
    }
}