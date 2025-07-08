import java.util.Comparator;
import java.util.TreeSet;

class Solution {
    int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;

        // 이전 행의 최대값들을 저장
        int[] prev = new int[cols];
        System.arraycopy(land[0], 0, prev, 0, cols);

        for(int i = 1; i < rows; i++) {
          int[] curr = new int[cols];

          for (int j = 0; j < cols; j++) {
            // 현재 열(j)과 다른 이전 행의 모든 열에서 최대값 찾기
            for (int k = 0; k < cols; k++) {
              if (k != j) {
                curr[j] = Math.max(curr[j], prev[k] + land[i][j]);
              }
            }
          }
          prev = curr;
        }

        // 최대값 반환
        int answer = 0;
        for (int value : prev) {
          answer = Math.max(answer, value);
        }

        return answer;
      }
}