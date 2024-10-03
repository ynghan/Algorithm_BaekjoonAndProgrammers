import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    static int[][] board;
    static int N;
    static int M;
    static List<Pos> chickens;
    static List<Pos> houses;
    // 최소 치킨 거리 저장할 변수
    static int minChickenDis = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        board = new int[N][N];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for(int i = 0; i < N ; i++) {
            String[] s1 = reader.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s1[j]);
                if(board[i][j] == 2) {
                    chickens.add(new Pos(i, j));
                }
                else if(board[i][j] == 1) {
                    houses.add(new Pos(i,j));
                }
            }
        }

        // 치킨 집 M개 고르기
        int size = chickens.size();
        boolean[] visited = new boolean[size];
        chooseM(visited, 0, 0);

        // M개의 치킨 거리 합 구하기

        // 최소 치킨 거리 출력하기
        System.out.println(minChickenDis);
    }

    private static void chooseM(boolean[] visited, int start, int depth) {

        if(depth == M) {
            // 치킨 거리 합 구하기
            int val = sum(visited);
            minChickenDis = Math.min(minChickenDis, val);
            return;
        }

        for(int i = start; i < chickens.size(); i++) {
            visited[i] = true;
            chooseM(visited, i+1,depth+1);
            visited[i] = false;
        }

    }

    private static int sum(boolean[] visited) {
        int sum = 0;

        for (Pos house : houses) {
            int min = Integer.MAX_VALUE;
            for(int k = 0; k < visited.length; k++) {
                if(visited[k]) {
                    Pos chicken = chickens.get(k);
                    int dis = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
                    if(min > dis) {
                        min = dis;
                    }
                }
            }
            sum += min;
        }
        return sum;
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
