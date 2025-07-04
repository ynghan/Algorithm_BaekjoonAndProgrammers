class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int N = friends.length; // 인원 수
        int M = gifts.length; // 거래 횟수

        // 주고 받은 개수를 나타내는 2차원 배열
        int[][] giveAndTake = new int[N][N];

        // 2차원 배열에 저장하기
        for(int i = 0; i < M; i++) {
          String[] s = gifts[i].split(" ");
          int give = -1;
          int take = -1;

          for (int j = 0; j < N; j++) {
            if(s[0].equals(friends[j])) {
              give = j;
            }
            else if (s[1].equals(friends[j])) {
              take = j;
            }
          }
          // 행이 준 사람, 열이 받은 사람
          giveAndTake[give][take]++;
        }

        int[] arr = new int[N];
        // 조합을 사용해야 하는데,,,
        for(int i = 0; i < N; i++) {
          for(int j = i+1; j < N; j++) {
            if(giveAndTake[i][j] > giveAndTake[j][i]) {
              arr[i]++;
            }
            else if(giveAndTake[i][j] < giveAndTake[j][i]) {
              arr[j]++;
            } else {
              int giveScore = 0;
              int takeScore = 0;
              for(int k = 0; k < N; k++) {
                giveScore += giveAndTake[i][k];
                takeScore += giveAndTake[j][k];
              }
              for(int k = 0; k < N; k++) {
                giveScore -= giveAndTake[k][i];
                takeScore -= giveAndTake[k][j];
              }
              if(giveScore > takeScore) {
                arr[i]++;
              }
              else if(giveScore < takeScore) {
                arr[j]++;
              }
            }
          }
        }

        int max = -1;
        for (int i : arr) {
          if(max < i) {
            max = i;
          }
        }
        answer = max;
        return answer;
    }
}