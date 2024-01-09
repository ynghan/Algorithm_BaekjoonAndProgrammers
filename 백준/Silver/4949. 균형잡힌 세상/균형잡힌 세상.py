import sys


class Solution:
    def balancedWorld(self):
        input = sys.stdin.readline
        result = []
        while True:
            stack = []
            line = input().rstrip()

            if line == '.':
                break

            for char in line:
                if char == "(":
                    stack.append(char)

                elif char == "[":
                    stack.append(char)

                elif char == "]":
                    if stack and stack[-1] == "[":
                        stack.pop(-1)
                    else:
                        stack.append(char)
                        break

                elif char == ")":
                    if stack and stack[-1] == "(":
                        stack.pop(-1)
                    else:
                        stack.append(char)
                        break

            if stack:
                result.append("no")

            else:
                result.append("yes")

        for line in result:
            print(line)


a = Solution()
a.balancedWorld()