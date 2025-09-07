import java.util.*;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int idx = 0;
        int count = 0;
        int[] arr = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]] += 1;
        }
        Arrays.sort(arr);
        
        int answer = 0;
        int sum = 0;
        for(int i = arr.length-1; i >= 0; i--) {
            if(k <= sum) break;
            
            answer++;
            sum += arr[i];
        }
        
        return answer;
    }
}