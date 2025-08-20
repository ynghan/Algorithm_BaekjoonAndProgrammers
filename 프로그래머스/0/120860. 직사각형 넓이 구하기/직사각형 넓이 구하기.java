class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = dots[0][0];
        int y = dots[0][1];
        int a = 0;
        int b = 0;
        for(int i = 1; i < dots.length; i++) {
            if( x == dots[i][0] && y == dots[i][1] ) {
                continue;
            } else if (x == dots[i][0]) {
                a = Math.abs(y - dots[i][1]);
            } else if (y == dots[i][1]) {
                b = Math.abs(x - dots[i][0]);
            }
        }
        
        return a*b;
    }
}