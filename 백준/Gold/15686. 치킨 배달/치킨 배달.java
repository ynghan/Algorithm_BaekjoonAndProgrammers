import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static List<Pos> chickens;
    static List<Pos> houses;
    static int minChickenDis = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for(int i = 0; i < N ; i++) {
            String[] s1 = reader.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                int val = Integer.parseInt(s1[j]);
                if(val == 2) {
                    chickens.add(new Pos(i, j));
                }
                else if(val == 1) {
                    houses.add(new Pos(i,j));
                }
            }
        }

        // 치킨 집 M개 고르기
        boolean[] visited = new boolean[chickens.size()];
        chooseM(visited, 0, 0);

        // 최소 치킨 거리 출력하기
        System.out.println(minChickenDis);
    }

    private static void chooseM(boolean[] visited, int start, int depth) {
        if(depth == M) {
            // 치킨 거리 합 구하기
            int sum = calculateChickenDistance(visited);
            minChickenDis = Math.min(minChickenDis, sum);
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            chooseM(visited, i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static int calculateChickenDistance(boolean[] visited) {
        int totalDistance = 0;
        for (Pos house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (visited[i]) {
                    Pos chicken = chickens.get(i);
                    int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }

    public static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}