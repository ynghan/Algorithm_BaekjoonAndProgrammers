class Solution {
    public int solution(String number) {
        int add = 0;
        for(int i = 0; i < number.length(); i++) {
            add += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return add % 9;
    }
}