class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int hopeMin = toMinutes(schedules[i]);
            int endMin = hopeMin + 10;
            boolean allOnTime = true;

            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1; // 1~7 유지

                if (day >= 1 && day <= 5) { // 평일
                    int actualMin = toMinutes(timelogs[i][j]);

                    if (actualMin > endMin) {
                        allOnTime = false;
                        break;
                    }
                }
            }

            if (allOnTime) {
                answer++;
            }
        }

        return answer;
    }

    private int toMinutes(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}