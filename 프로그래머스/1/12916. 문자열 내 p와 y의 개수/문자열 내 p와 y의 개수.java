class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        char[] c = s.toLowerCase().toCharArray();
        for(int i = 0; i < c.length; i++) {
            if(c[i] == 'p') {
                pCnt++;
            }
            if(c[i] == 'y') {
                yCnt++;
            }
        }
        return pCnt == yCnt ? true : false;
    }
}