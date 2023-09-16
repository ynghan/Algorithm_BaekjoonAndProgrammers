import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int num = 0;
        for(int i : query) {
            if(num % 2 == 0) {
                arr = even(arr, i);
            }
            else {
                arr = odd(arr, i);
            }
            num++;
        }
        
        return arr;
    }

    public static int[] even(int[] arr, int query_value) {
        int[] sub = new int[query_value + 1];
        for(int i = 0; i <= query_value; i++) {
            sub[i] = arr[i];
        }
        return sub;
    }

    public static int[] odd(int[] arr, int query_value) {
        int[] sub = new int[arr.length - query_value];
        for(int i = query_value; i < arr.length; i++) {
            sub[i - query_value] = arr[i];
        }
        return sub;
    }
}