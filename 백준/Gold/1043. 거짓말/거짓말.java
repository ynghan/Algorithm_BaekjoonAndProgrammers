import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Integer> reals;
    static boolean[] parties;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 사람 수
        int M = Integer.parseInt(s[1]); // 파티 수
        reals = new HashSet<>();
        parties = new boolean[M];
        visited = new boolean[N + 1];
        list = new ArrayList[M];

        // 진실을 아는 사람의 수와 해당 사람의 번호
        String[] s1 = reader.readLine().split(" ");
        int real = Integer.parseInt(s1[0]);

        for (int r = 1; r <= real; r++) {
            int o = Integer.parseInt(s1[r]);
            reals.add(o);
        }

        // 각 파티에 속한 사람들을 저장하는 리스트 배열 생성
        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
            String[] s2 = reader.readLine().split(" ");
            int cnt = Integer.parseInt(s2[0]);
            for (int j = 1; j <= cnt; j++) {
                int p = Integer.parseInt(s2[j]);
                list[i].add(p);
            }
        }

        // 진실을 아는 사람과 연결된 모든 사람을 찾아서 reals에 추가
        for (int i = 0; i < M; i++) {
            for (Integer person : list[i]) {
                if (reals.contains(person)) {
                    markConnectedPeople(i);
                    break;
                }
            }
        }

        // 파티에서 진실을 아는 사람이 없는 경우 count
        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (!parties[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    // DFS로 연결된 사람들을 재귀적으로 탐색
    static void markConnectedPeople(int partyIndex) {
        if (parties[partyIndex]) return; // 이미 처리된 파티는 무시
        parties[partyIndex] = true; // 이 파티는 진실을 아는 사람이 있음

        // 이 파티의 모든 사람을 방문
        for (Integer person : list[partyIndex]) {
            if (!visited[person]) {
                visited[person] = true; // 이 사람을 방문했다고 표시
                // 해당 사람과 연결된 모든 파티를 찾아서 마킹
                for (int i = 0; i < list.length; i++) {
                    if (list[i].contains(person)) {
                        markConnectedPeople(i); // 재귀 호출
                    }
                }
            }
        }
    }
}
