import sys

class Solution:
    def budget(self):
        input = sys.stdin.readline
        N = int(input())
        city = list(map(int, input().split()))
        total_budget = int(input())
        city.sort()

        start, end = 0, city[-1]
        while start <= end:
            mid = (start + end) // 2
            total = 0
            for i in city:
                if i <= mid:
                    total += i
                else:
                    total += mid
            if total <= total_budget:
                start = mid + 1
            else:
                end = mid - 1
        print(end)

Solution().budget()