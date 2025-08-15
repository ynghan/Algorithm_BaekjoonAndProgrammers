import java.util.*;
// 1에서 20억 숫자로 반환되어야 함.

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        Map<String, String> map = new HashMap<>();
        map.put("ze", "04");
        map.put("on", "13");
        map.put("tw", "23");
        map.put("th", "35");
        map.put("fo", "44");
        map.put("fi", "54");
        map.put("si", "63");
        map.put("se", "75");
        map.put("ei", "85");
        map.put("ni", "94");
        
        int idx = 0;
        // System.out.println(s.substring(0,2));
        char[] arr = s.toCharArray();
        while(idx < s.length()) {
            if(arr[idx] >= '0' && arr[idx] <= '9') {
                sb.append(arr[idx]);
                idx += 1;
            } else {
                String s1 = map.get(s.substring(idx, idx+2));
                int length = s1.charAt(1) - '0';
                sb.append(s1.charAt(0));
                idx += length;
            }
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}