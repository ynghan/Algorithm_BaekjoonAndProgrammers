import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int ans1 = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int ans2 = Integer.parseInt(st.nextToken());

        int det = x1 * y2 - y1 * x2;

        if (det == 0) {
            System.out.println("No unique solution");
            return;
        }

        int x = (y2 * ans1 - y1 * ans2) / det;
        int y = (x1 * ans2 - x2 * ans1) / det;

        if (x1 * x + y1 * y == ans1 && x2 * x + y2 * y == ans2) {
            System.out.println(x + " " + y);
        } else {
            System.out.println("No integer solution");
        }
    }
}