import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int q = 0; q < commands.length; q++) {
            StringBuilder sb = new StringBuilder();
            int i = commands[q][0]-1;
            int j = commands[q][1]-1;
            int k = commands[q][2]-1;
            int[] newArr = new int[j-i+1];
            for(int p = i; p <= j; p++) {
                newArr[p-i] = array[p];
            }
            Arrays.sort(newArr);
            answer[q] = newArr[k];
        }
        return answer;
    }
}