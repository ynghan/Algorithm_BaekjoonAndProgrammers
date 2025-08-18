class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] month = {30,29,31,30,31,30,31,31,30,31,30,31};
        String[] result = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day = 0;
        
        if(a > 1) {
            for(int i = 0; i < a-1; i++) {
                day += month[i];
            }
        } else {
            day -= 1;
        }
        day += b;
        day %= 7;
        return result[day];
    }
}