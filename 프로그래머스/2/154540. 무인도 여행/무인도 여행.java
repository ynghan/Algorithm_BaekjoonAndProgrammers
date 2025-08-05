import java.util.*;

class Solution {
    static boolean[][] visited;
    static int n; // 가로
    static int m; // 세로
    static int[][] islands;

    public int[] solution(String[] maps) {
        m = maps.length;      // 세로
        n = maps[0].length(); // 가로

        islands = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            char[] point = maps[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (point[j] == 'X') {
                    islands[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    islands[i][j] = point[j] - '0';
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int val = bfs(i, j);
                    list.add(val);
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int bfs(int startY, int startX) {
        visited[startY][startX] = true;

        int total = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int y = pos[0];
            int x = pos[1];

            total += islands[y][x];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return total;
    }
}