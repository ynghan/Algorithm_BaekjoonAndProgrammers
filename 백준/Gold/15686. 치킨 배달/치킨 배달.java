import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<int[]> houses, chickens;
    static int minChickenDis = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    houses.add(new int[]{i, j});
                } else if (val == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        combination(new int[M], 0, 0);
        System.out.println(minChickenDis);
    }

    private static void combination(int[] selected, int start, int depth) {
        if (depth == M) {
            minChickenDis = Math.min(minChickenDis, calculateTotalDistance(selected));
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            combination(selected, i + 1, depth + 1);
        }
    }

    private static int calculateTotalDistance(int[] selected) {
        int totalDistance = 0;
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int i : selected) {
                int[] chicken = chickens.get(i);
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
            if (totalDistance >= minChickenDis) return Integer.MAX_VALUE;
        }
        return totalDistance;
    }
}