class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(n > 2) {
            if(n >= a && a > n/2 && n >= b && b > n/2) {
                n /= 2;
                a -= n;
                b -= n;
            } else if(n/2 >= a && a > 0 && n/2 >= b && b > 0) {
                n /= 2;
            } else {
                break;
            }
        }

        int count = 0;
        while(n > 1) {
            n /= 2;
            count++;
        }
        return count;
    }
}