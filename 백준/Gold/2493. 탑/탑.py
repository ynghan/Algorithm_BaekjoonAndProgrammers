import sys

class Solution:
    def top(self):
        input = sys.stdin.readline
        N = int(input())
        tops = list(map(int, input().split()))
        stack = []
        result = [0] * N

        for i in range(N):
            while stack and tops[stack[-1]] < tops[i]:
                stack.pop()
            if stack:
                result[i] = stack[-1] + 1
            stack.append(i)

        for num in result:
            print(num, end=' ')


a = Solution()
a.top()