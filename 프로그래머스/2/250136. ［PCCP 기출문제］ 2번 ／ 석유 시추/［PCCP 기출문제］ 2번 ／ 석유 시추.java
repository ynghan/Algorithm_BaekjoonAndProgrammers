import java.util.*;

class Solution {
    public int solution(int[][] land) {
        // 세로 길이
        int N = land.length;
        // 가로 길이
        int M = land[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        char team = 'a' - 1;

        char[][] visited = new char[N][M];
        Map<Character, Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();

        // 이제 지역마다 이름 붙여줬고, 크기도 설정해두었다.
        for(int i = 0; i < N; i++) {
          for(int j = 0; j < M; j++) {
            int count = 0;
            if(land[i][j] == 1 && visited[i][j] == 0) {
              queue.offer(new int[]{i,j});
              team++;
              while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                visited[poll[0]][poll[1]] = team;
                count++;
                for(int k = 0; k < 4; k++) {
                  int x = poll[0] + dx[k];
                  int y = poll[1] + dy[k];
                  if(x >= 0 && y >= 0 && x < N && y < M) {
                    if(land[x][y] == 1 && visited[x][y] == 0) {
                      queue.offer(new int[]{x,y});
                      visited[x][y] = team;
                    }
                  }
                }
              }
              map.put(team, count);
            }
          }
        }

        int answer = 0;
        for(int i = 0; i < M; i++) {
          int size = 0;
          HashSet<Character> set = new HashSet<>();
          for(int j = 0; j < N; j++) {
            if(visited[j][i] != 0) set.add(visited[j][i]);
          }
          for (Character c : set) {
            size += map.get(c);
          }
          set.clear();
          if(answer < size) answer = size;
        }
        return answer;
    }
}