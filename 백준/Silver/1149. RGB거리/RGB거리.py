import sys


class Solution:
    def rgb(self):

        input = sys.stdin.readline
        N = int(input())

        houses = [tuple(map(int, input().split())) for _ in range(N)]

        minimum = houses[0]

        for i in range(1, len(houses)):
            temp = [0,0,0]
            temp[0] = min(minimum[1], minimum[2]) + houses[i][0]
            temp[1] = min(minimum[0], minimum[2]) + houses[i][1]
            temp[2] = min(minimum[0], minimum[1]) + houses[i][2]

            minimum = temp

        return min(minimum)


res = Solution().rgb()
print(res)