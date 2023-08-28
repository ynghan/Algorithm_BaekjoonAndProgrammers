class Solution {
    public int[] solution(int[] num_list) {
                
        int length = num_list.length;

        int[] answer = new int[length + 1];

        int last_comp = num_list[length - 2] >= num_list[length - 1] 
            ? num_list[length - 1] * 2 : num_list[length - 1] - num_list[length - 2];

        for( int i = 0 ; i < length; i++) {
            answer[i] = num_list[i];
        }
        
        answer[length] = last_comp;
        
        return answer;
    }
}