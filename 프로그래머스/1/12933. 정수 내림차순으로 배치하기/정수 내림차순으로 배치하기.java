import java.util.*;

class Solution {
    public long solution(long n) {
        int[] arr = String.valueOf(n).chars().map(ch -> ch - '0').toArray();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length ;j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]); 
        }
        return Long.parseLong(sb.toString());
    }
}