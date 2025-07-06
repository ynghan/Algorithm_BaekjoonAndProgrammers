class Solution {
    int[] numbers;
    int target;
    int answer;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer = 0;

        dfs(0, 0);

        return answer;
    }

    public void dfs(int result, int depth) {
        if (depth == numbers.length) {
            if (result == target) {
                answer++;
            }
            return;
        }

        dfs(result + numbers[depth], depth + 1);
        dfs(result - numbers[depth], depth + 1);
    }
}