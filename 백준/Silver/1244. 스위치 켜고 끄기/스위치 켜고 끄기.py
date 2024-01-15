import sys


class Solution:
    def switch(self):
        input = sys.stdin.readline

        N = int(input())
        state = [0] + list(map(int, input().rstrip().split()))
        students = int(input())

        for _ in range(students):
            sex, num = map(int, input().rstrip().split())
            # 남자
            if sex == 1:
                for i in range(num, N+1, num):
                    state[i] = 1 - state[i]
            # 여자
            else:
                state[num] = 1 - state[num]
                for k in range(1, N//2 + 1):
                    if num - k < 1 or num + k > N:
                        break
                    if state[num - k] == state[num + k]:
                        state[num - k] = 1 - state[num - k]
                        state[num + k] = 1 - state[num + k]
                    else:
                        break

        for i in range(1, N+1):
            print(state[i], end = ' ')
            if i % 20 == 0:
                print()


a = Solution()
a.switch()
