class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = n < answer.length ? num_list[n] : num_list[n - num_list.length];
            n++;
        }
        return answer;
    }
}