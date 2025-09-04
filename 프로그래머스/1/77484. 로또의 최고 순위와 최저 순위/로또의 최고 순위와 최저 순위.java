class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 0의 개수 + 맞힌 개수 -> 최고
        // 맞힌 개수 -> 최저
        int zero_num = 0;
        int success = 0;
        
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zero_num++;
            } else {
                for(int j = 0; j < win_nums.length; j++) {
                    if(win_nums[j] == lottos[i]) {
                        success++;
                        break;
                    }
                }
            }
        }
        
        answer[0] = 6- success - zero_num + 1 >= 6 ? 6 : 6- success - zero_num + 1;
        answer[1] = 6 - success + 1  >= 6 ? 6 : 6 - success + 1;
        
        
        return answer;
    }
}