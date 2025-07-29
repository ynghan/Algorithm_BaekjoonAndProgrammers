import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[maps.length][maps[0].length];
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
    
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] currPos = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = currPos[0] + dx[i];
                int ny = currPos[1] + dy[i];
                
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[currPos[0]][currPos[1]] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        
        int answer = visited[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }
    
}