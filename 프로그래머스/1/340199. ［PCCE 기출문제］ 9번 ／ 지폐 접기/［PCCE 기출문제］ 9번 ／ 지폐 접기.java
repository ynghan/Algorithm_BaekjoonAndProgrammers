class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int x = bill[0];
        int y = bill[1];
        while(x > 0 && y > 0) {
            if((x<=wallet[0]&&y<=wallet[1]) || (x<=wallet[1]&&y<=wallet[0])) {
                break;
            } else {
                answer++;
                boolean b = x>=y ? true : false;
                x = b ? x/2 : x;
                y = b ? y : y/2;
            }
        }
        
        return answer;
    }
}