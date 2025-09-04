import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0 ; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                Character ch = Character.valueOf(c);
                if(map.get(ch) == null) {
                    System.out.println(ch + " : " + j);
                    map.put(ch, j+1);
                } else {
                    if(j < map.get(ch)) {
                        map.put(ch, j+1);
                    }
                }
            }
        }
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                Character ch = Character.valueOf(targets[i].charAt(j));
                if(map.get(ch) == null) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += map.get(ch);
                }
            }
        }
        
        return answer;
    }
}