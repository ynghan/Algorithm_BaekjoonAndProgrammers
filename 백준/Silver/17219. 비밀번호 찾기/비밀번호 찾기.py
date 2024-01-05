import sys

class Solution:
    def findPassword(self):
        
        N, M = map(int, sys.stdin.readline().split())
        add = {}
        for _ in range(N):
            site, ps = input().split()
            add[site] = ps
        for _ in range(M):
            print(add[input().rstrip()])

a = Solution()
a.findPassword()