import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
          map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++) {
          for (String s : photo[i]) {
            if(map.get(s) != null) answer[i] += map.get(s);
          }
        }
        return answer;
    }
}