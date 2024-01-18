import sys


class Solution:
    def gasStation(self):
        input = sys.stdin.readline

        N = int(input())

        length = list(map(int, input().split()))
        price = list(map(int, input().split()))

        min_price = 0

        for i in range(len(price)-1):
            if length[i]:
                if price[i] >= price[i+1]:
                    min_price += price[i] * length[i]
                else:
                    min_price += price[i] * (length[i] + length[i+1])
                    length[i+1] = None
        print(min_price)

Solution().gasStation()