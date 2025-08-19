class Solution {
    public int solution(String s) {
        String[] tokens = s.split(" "); // 공백 기준 분리
        int sum = 0;
        int prev = 0; // 직전 숫자 저장

        for (String token : tokens) {
            if (token.equals("Z")) {
                sum -= prev; // 직전 숫자 취소
            } else {
                int num = Integer.parseInt(token);
                sum += num;
                prev = num; // 직전 숫자 갱신
            }
        }
        return sum;
    }
}