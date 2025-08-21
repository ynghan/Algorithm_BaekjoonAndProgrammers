class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] board1 = new int[n][n];
        int[][] board2 = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            int binary1 = arr1[i];
            int binary2 = arr2[i];
            for(int j = n-1; j >= 0; j--) {
                board1[i][j] = binary1 % 2;
                board2[i][j] = binary2 % 2;
                binary1 /= 2;
                binary2 /= 2;
            }
        }
        String[] answer = new String[n];
        StringBuilder sb;
        for(int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(board1[i][j] == 1|| board2[i][j] == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}