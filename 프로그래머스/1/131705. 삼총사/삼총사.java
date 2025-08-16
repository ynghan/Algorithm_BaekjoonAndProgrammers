class Solution {
    int count;

    public int solution(int[] number) {
        count = 0;
        dfs(number, 0, 0, 0); // idx, 뽑은개수, 현재합
        return count;
    }

    private void dfs(int[] number, int start, int picked, int sum) {
        if (picked == 3) {
            if (sum == 0) count++;
            return;
        }
        for (int i = start; i < number.length; i++) {
            dfs(number, i + 1, picked + 1, sum + number[i]);
        }
    }
}