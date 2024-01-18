# S4 11047
# https://www.acmicpc.net/problem/11047

"""
동전의 종류 N
몇 가지 동전의 합 K

출력 : 이때 필요한 동전 개수의 최솟값
"""
class Solution():
    def coin(self):
        N, K = map(int, input().rstrip().split())
        coin = list()
        max = list()
        for i in range(N):
            coin.append(int(input()))

        for i in range(0, len(coin)-1, 1):
            div = coin[i+1] % coin[i]
            maximum = coin[i+1] // coin[i] - 1
            if div == 0:
                max.append(maximum)
            else:
                max.append(0)

        max.append(K // coin[-1])

        res = 0
        while K > 0:
            for i in range(len(coin)-1, -1, -1):
                if K >= coin[i]:
                    if max[i] >= K // coin[i]:
                        div = K // coin[i]
                        res += div
                        K -= coin[i] * div

        print(res)

a = Solution()
a.coin()


