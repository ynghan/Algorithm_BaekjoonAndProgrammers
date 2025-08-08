import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String call : callings) {
            int rank = map.get(call);
            String name = players[rank-1];
            players[rank-1] = players[rank];
            players[rank] = name;
            map.put(players[rank-1], rank-1);
            map.put(players[rank], rank);
        }
        
        return players;
    }
}