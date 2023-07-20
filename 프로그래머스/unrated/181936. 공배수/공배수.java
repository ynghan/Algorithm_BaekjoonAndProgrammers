class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;
        return (number % m == 0 && number % n == 0) ? 1 : 0;
    }
}