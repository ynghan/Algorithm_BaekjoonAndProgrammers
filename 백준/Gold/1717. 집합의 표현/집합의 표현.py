import sys


class Solution:
    def representationOfSet(self):

        input = sys.stdin.readline

        N, M = map(int, input().split())
        parent = [i for i in range(N+1)]

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(a, b):
            a = find(a)
            b = find(b)
            if a < b:
                parent[a] = b
            else:
                parent[b] = a

        for i in range(M):
            x, a, b = list(map(int, input().split()))
            if not x:
                union(a, b)
            else:
                if find(a) == find(b):
                    print("YES")
                else:
                    print("NO")

A = Solution()
A.representationOfSet()