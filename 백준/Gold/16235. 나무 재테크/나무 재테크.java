import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// N x N 땅
public class Main {

    static int N, M, K; // 땅의 크기(N), 나무의 수(M), 연수(K)
    static List<Tree>[][] trees; // 각 칸에 심어진 나무 리스트
    static int[][] ground;
    static int[][] s2d2;

    // 나무 클래스
    static class Tree {
        int age; // 나무의 나이

        Tree(int age) {
            this.age = age; // 나이 초기화
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);

        // 땅
        trees = new ArrayList[N][N];
        ground = new int[N][N];
        s2d2 = new int[N][N];

        // 땅의 영양분과 s2d2 입력받기
        for (int i = 0; i < N; i++) {
            String[] rc = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ground[i][j] = 5;
                s2d2[i][j] = Integer.parseInt(rc[j]);
                trees[i][j] = new ArrayList<>(); // 각 칸의 나무 리스트 초기화
            }
        }

        // 나무 리스트 입력받기
        for (int i = 0; i < M; i++) {
            String[] m = reader.readLine().split(" ");
            int x = Integer.parseInt(m[0]) - 1; // 0 기반 인덱스
            int y = Integer.parseInt(m[1]) - 1; // 0 기반 인덱스
            int age = Integer.parseInt(m[2]);

            trees[x][y].add(new Tree(age));
        }

        for (int k = 0; k < K; k++) {

            // 봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Collections.sort(trees[i][j], Comparator.comparingInt(t -> t.age));
                    int deadT = 0; // 죽은 나무에서 나오는 양분
                    List<Tree> remainT = new ArrayList<>();

                    for (Tree tree : trees[i][j]) {
                        if (ground[i][j] >= tree.age) {
                            ground[i][j] -= tree.age;
                            remainT.add(tree);
                            tree.age++;
                        } else {
                            deadT += tree.age / 2;
                        }
                    }
                    ground[i][j] += deadT;
                    trees[i][j] = remainT;
                }
            }

            // 가을
            int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Tree tree : trees[i][j]) {
                        if (tree.age % 5 == 0) {
                            for (int[] dir : directions) {
                                int ni = i + dir[0];
                                int nj = j + dir[1];
                                if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                                    trees[ni][nj].add(new Tree(1));
                                }
                            }
                        }
                    }
                }
            }

            // 겨울
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ground[i][j] += s2d2[i][j];
                }
            }
        }

        // 나무의 개수를 출력한다.
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += trees[i][j].size();
            }
        }

        System.out.println(count);
    }
}
