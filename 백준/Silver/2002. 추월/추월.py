import sys


class Solution:
    def overTaking(self):
        input = sys.stdin.readline

        N = int(input())
        start = []
        left = []
        right = []
        clue = int()
        count = 0

        for i in range(N):
            start.append(input().rstrip())

        for j in range(N):
            right.append(input().rstrip())

        while True:
            for q in range(len(start)):
                if start[0] == right[q]:
                    clue = q
            # clue 개 : 추월한 자동차 수
            count += clue

            for k in range(clue+1):
                pop = right.pop(0)
                index = start.index(pop)
                start.pop(index)
                left.append(pop)

            if start == right:
                break



        # print(start)
        # print(left)
        # print(right)
        print(count)

        # while right:
        #     for str in right:
        #         for i in range(len(start)):
        #             if str
        #
        #     # clue - a 개 : 추월한 자동차 수
        #     count += clue
        #     start.pop(0)
        #
        #     for b in range(clue):
        #         left.append(right.pop(0))
        #
        # print(count)

a = Solution()
a.overTaking()

