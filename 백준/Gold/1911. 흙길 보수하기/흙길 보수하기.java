import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 어젯밤 겨울 캠프 장소에서 본원까지 이어지는, 흙으로 된 비밀길 위에 폭우가 내려서 N개의 물웅덩이가 생겼다.
 * 월드학원은 물웅덩이를 덮을 수 있는 길이가 L인 널빤지들을 충분히 가지고 있어서, 이들로 다리를 만들어 물웅덩이들을 모두 덮으려고 한다.
 * 물웅덩이들의 위치와 크기에 대한 정보가 주어질 때, 모든 물웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수를 구하여라.
 */
public class Main {

    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);



        List<int[]> pair = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] s1 = reader.readLine().split(" ");
            int st = Integer.parseInt(s1[0]);
            int en = Integer.parseInt(s1[1]);
            pair.add(new int[]{st, en});
        }

        // 물웅덩이 정렬
        pair.sort(Comparator.comparingInt(a -> a[0]));

        int count = 0;
        int covered = 0; // 현재 덮인 범위

        for (int[] p : pair) {
            int st = p[0];
            int en = p[1];

            // 현재 덮인 범위가 물웅덩이의 시작보다 작으면 널빤지를 추가해야 함
            if(covered < st) {
                covered = st; // 현재 덮인 범위를 물웅덩이 시작으로 이동
            }

            while(covered < en) {
                covered += L; // 널빤지의 길이만큼 덮음
                count++;
            }
        }

        /**
         * 모든 물웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수를 출력한다.
         */
        System.out.println(count);
    }
}
