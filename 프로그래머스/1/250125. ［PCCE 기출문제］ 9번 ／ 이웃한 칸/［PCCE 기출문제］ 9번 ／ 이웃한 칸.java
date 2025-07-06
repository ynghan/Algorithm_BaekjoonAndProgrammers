class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        String color = board[h][w];
        
        for(int[] d : dir) {
            if(h+d[0] >= 0 && h+d[0] < board.length && w+d[1] >= 0 && w+d[1] < board[0].length) {
                if(board[h+d[0]][w+d[1]].equals(color)) {
                    answer++;
                }
            }    
        }
        
        
        return answer;
    }
}