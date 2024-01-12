import sys

class Solution():
    def backtrack(self):
        input = sys.stdin.readline
        T = int(input())

        cases = [int(input()) for _ in range(T)]
        res = []

        def dfs(n):
            if n == 0 or n == 1:
                return 1
            elif n == 2:
                return 2

            return dfs(n-1) + dfs(n-2) + dfs(n-3)

        for case in cases:
            total = dfs(case)
            res.append(total)

        for ans in res:
            print(ans)

a = Solution()
a.backtrack()