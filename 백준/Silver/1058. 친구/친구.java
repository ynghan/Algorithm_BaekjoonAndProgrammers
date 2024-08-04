import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String string = reader.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        List<Set<Integer>> friends = new ArrayList<>();

        // 직접 친구들만 넣기
        for (int i = 0; i < N; i++) {
            Set<Integer> friendSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'Y') {
                    friendSet.add(j);
                }
            }
            friends.add(friendSet);
        }

        int maxFriends = 0;

        // 친구의 친구 추가
        for (int i = 0; i < N; i++) {
            Set<Integer> friendsSet = friends.get(i);
            Set<Integer> tempSet = new HashSet<>(friendsSet); // 친구 목록 복사

            for (Integer friend : friendsSet) {
                Set<Integer> friendOfFriend = friends.get(friend);
                for (Integer fof : friendOfFriend) {
                    if (fof != i) { // 본인은 제외
                        tempSet.add(fof);
                    }
                }
            }

            // 본인 제외한 친구 수 계산
            int count = tempSet.size(); // 친구 + 친구의 친구 수
            maxFriends = Math.max(maxFriends, count);
        }

        System.out.println(maxFriends);
    }
}