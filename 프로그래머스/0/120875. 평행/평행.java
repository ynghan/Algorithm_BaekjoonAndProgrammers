import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        // (0,1) vs (2,3)
        if (parallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        // (0,2) vs (1,3)
        if (parallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        // (0,3) vs (1,2)
        if (parallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    // 두 선분 (a,b)와 (c,d)가 평행인지: (y2 - y1)*(x4 - x3) == (y4 - y3)*(x2 - x1)
    private boolean parallel(int[] a, int[] b, int[] c, int[] d) {
        long dy1 = (long)b[1] - a[1], dx1 = (long)b[0] - a[0];
        long dy2 = (long)d[1] - c[1], dx2 = (long)d[0] - c[0];
        return dy1 * dx2 == dy2 * dx1;
    }
}