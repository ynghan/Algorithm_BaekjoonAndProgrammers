import sys


class Solution:
    def gasStation(self):
        input = sys.stdin.readline

        N = int(input())

        length = list(map(int, input().split()))
        price = list(map(int, input().split()))

        min_price = price[0]
        total = 0
        for i in range(len(price) - 1):
            if price[i] < min_price:
                min_price = price[i]
            total += min_price * length[i]

        print(total)

Solution().gasStation()