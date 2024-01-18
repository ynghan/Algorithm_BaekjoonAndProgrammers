class Solution:
    def maxProfit(self):
        N = int(input())
        time_per_persion = list(map(int, input().split()))

        time_per_persion.sort()
        res = 0
        for i in range(N):
            res += time_per_persion[i] * (N-i)

        print(res)

Solution().maxProfit()