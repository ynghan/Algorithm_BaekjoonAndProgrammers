import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet<>();
        Arrays.sort(numbers);
        boolean[] visited = new boolean[numbers.length];
        int[] output = new int[2];
        dfs(numbers, visited, output, 0, answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void dfs(int[] numbers, boolean[] visited, int[] output, int depth, TreeSet<Integer> answer) {
        
        if(output.length == depth) {
            answer.add(output[0] + output[1]);
            return;
        }
        
        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                dfs(numbers, visited, output, depth+1, answer);
                visited[i] = false;
            }
        }
    }
}