class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int total = timelogs.length;
        for(int i = 0; i < schedules.length; i++) {
          schedules[i] += 10;
          if(schedules[i] % 100 >= 60) {
            schedules[i] += 40;
          }
        }
        for(int i = 0; i < timelogs.length; i++) {
          for(int j = 0; j < timelogs[i].length; j++) {
            int day = (j + startday) % 7;
            if(day != 6 && day != 0) {
              if(timelogs[i][j] - schedules[i] > 0) {
                total--;
                break;
              }
            }
          }
        }

        return total;
    }
}