import sys

class Solution:
    def newEmployee(self):
        input = sys.stdin.readline
        T = int(input())
        employee = list()
        for _ in range(T):
            N = int(input())
            empl = list()
            for i in range(N):
                empl.append(tuple(map(int, input().split())))
            employee.append(empl)

        def remove(empl):
            empl.sort()
            min_interview = empl[0][1]
            count = 1
            for i in range(1, len(empl)):
                if empl[i][1] < min_interview:
                    min_interview = empl[i][1]
                    count += 1
            return count

        for i in range(T):
            print(remove(employee[i]))

Solution().newEmployee()