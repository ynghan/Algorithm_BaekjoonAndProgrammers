import java.util.*;
import java.math.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        Map<Integer,int[]> map = new HashMap<>();
        
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        map.put(0, new int[]{3,1});        
        int[] right = new int[]{3,0};
        int[] left = new int[]{3,2};
        
        
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = map.get(numbers[i]);
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = map.get(numbers[i]);
            } else {
                int[] pos = map.get(numbers[i]);
                double rDis = Math.abs(pos[0] - right[0]) + Math.abs(pos[1] - right[1]);
                double lDis = Math.abs(pos[0] - left[0]) + Math.abs(pos[1] - left[1]);
                if(rDis < lDis) {
                    right = pos;
                    sb.append("R");
                } else if(rDis > lDis) {
                    left = pos;
                    sb.append("L");
                } else {
                    if(hand.equals("right")) {
                        right = pos;
                        sb.append("R");
                    } else {
                        left = pos;
                        sb.append("L");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}