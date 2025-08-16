import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ;i < arr.length ;i++) {
            if(arr[i] % divisor == 0) list.add(arr[i]);
        }
        int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr2);
        
        return arr2.length == 0 ? new int[]{-1} : arr2;
    }
}