class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n+1][m+1];
        
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            dp[y][x] = -1;
        }
        
        dp[1][1] = 1;
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if((x == 1 && y == 1) || dp[y][x] == -1) {
                    continue;
                }
                
                long fromLeft = dp[y][x - 1] == -1 ? 0 : dp[y][x-1];
                long fromUp = dp[y - 1][x] == -1 ? 0 : dp[y-1][x];
                
                dp[y][x] = (fromLeft + fromUp) % MOD;
            }
        }
        return (int) dp[n][m];
    }
}