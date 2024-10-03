import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] belt;
    static boolean[] robot;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (countZeroDurability() < K) {
            step++;
            rotate();
            moveRobots();
            addNewRobot();
        }

        System.out.println(step);
    }

    public static void rotate() {
        int temp = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = temp;

        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;  // 내리는 위치의 로봇 제거
    }

    public static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                belt[i + 1]--;
            }
        }
        robot[N - 1] = false;  // 내리는 위치의 로봇 제거
    }

    public static void addNewRobot() {
        if (belt[0] > 0 && !robot[0]) {
            robot[0] = true;
            belt[0]--;
        }
    }

    public static int countZeroDurability() {
        int count = 0;
        for (int durability : belt) {
            if (durability == 0) {
                count++;
            }
        }
        return count;
    }
}