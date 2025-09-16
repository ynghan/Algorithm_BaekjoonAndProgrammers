import java.util.*;

// 캐릭터가 상대 팀 진영에 도착하기 위해 지나가야 하는 칸의 개수의 최소값 return 
// 검은 색 : 막혀있음 -> 0
// 흰색 : 갈수있음 -> 1
class Solution {
    public int solution(int[][] maps) {
        int x, y, ex, ey;
        // 캐릭터 좌표
        x = 0;
        y = 0;
        // 적 좌표
        ex = maps.length - 1;
        ey = maps[0].length - 1;
        // 방문 체크
        int[][] visited = new int[maps.length][maps[0].length];
        for(int i = 0; i < maps.length; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        
        // 출발 -> 모든 경우의 수 -> bfs
        // 모든 경우의 수를 가기 위해서 할일 
        // 1. 큐 자료구조 사용
        Deque<int[]> deque = new ArrayDeque<>();
        // 2. dx, dy 이동 방향 설정
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        deque.add(new int[]{x,y});
        visited[x][y] = 1;
        while(!deque.isEmpty()) {
            int[] pos = deque.poll();
            int px = pos[0];
            int py = pos[1];
            for(int i = 0; i < 4; i++) {
                int cx = px + dx[i];
                int cy = py + dy[i];
                // 범위 설정 
                if(cx >= 0 && cx < maps.length && cy >= 0 && cy < maps[0].length) {
                    // 벽이라면 이동 불가
                    if(maps[cx][cy] == 1) {
                        if(visited[cx][cy] > visited[px][py] + 1) {
                            visited[cx][cy] = visited[px][py] + 1;
                            deque.add(new int[]{cx, cy});
                        }
                    }
                }
            }
        }
        
        return visited[ex][ey] == Integer.MAX_VALUE ? -1 : visited[ex][ey];
        
        
    }
}