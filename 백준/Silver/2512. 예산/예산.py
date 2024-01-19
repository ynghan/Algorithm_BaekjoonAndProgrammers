import sys

class Solution:
    def budget(self):
        input = sys.stdin.readline
        N = int(input())
        city = list(map(int, input().split()))
        total_budget = int(input())
        city.sort()

        maximum_budget = 0
        for i in range(len(city)):
            if city[i] * (len(city) - i) > total_budget:
                maximum_budget = total_budget // (len(city) - i)
                break
            total_budget -= city[i]
        else:
            maximum_budget = city[-1]

        print(maximum_budget)

Solution().budget()
