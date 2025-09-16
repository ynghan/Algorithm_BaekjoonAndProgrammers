import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            if(min > val) {
                min = val;
                idx = i;
            }
        }
        list.remove(idx);
        
        if(list.isEmpty()) {
            return new int[]{-1};
        } else {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}