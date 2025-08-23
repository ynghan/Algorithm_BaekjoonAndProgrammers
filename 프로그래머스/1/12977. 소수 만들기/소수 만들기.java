class Solution {
    static int answer = 0;
    public int solution(int[] nums) {
        
        int count = 0;
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int[] nums, boolean[] visited, int idx, int depth) {
        if(depth == 3) {
            int add =0;
            for(int i = 0; i < nums.length; i++) {
                if(visited[i]) add += nums[i];
            }
            
            int count = 0;
            for(int i = 1; i <= (int)Math.sqrt(add); i++) {
                if(add % i == 0) count++;
                if(count > 1) {
                    return;
                }
            }
            answer++;
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(nums, visited, i+1, depth + 1);
                visited[i] = false;
            }
        }
        
    }
}