class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int[] pos = {0,0};
        
        for(String input : keyinput) {
            int idx;
            if(input.equals("left")) {
                idx = 2;
            } else if(input.equals("right")) {
                idx = 3;
            } else if(input.equals("up")) {
                idx = 1;
            } else {
                idx = 0;
            }
            int nextx = pos[0] + dx[idx];
            int nexty = pos[1] + dy[idx];
            
            if(nextx < -(board[0]/2) || nextx > board[0]/2 || nexty < -(board[1]/2) || nexty > board[1]/2) {
                continue;
            }
            pos[0] = nextx;
            pos[1] = nexty;
            
        }
        
        return pos;
    }
}