import sys

# input() : 한 줄의 문자열을 입력
# map() : 리스트의 모든 원소에 각각 특정한 함수를 적용할 때 사용

class Solution:
    def findIncludingNumber(self):
        N = int(input())
        A = list(map(int, sys.stdin.readline().split()))
        M = int(input())
        arr = list(map(int, input().split()))

        dictionary = {num : i for i, num in enumerate(A)}

        for i in arr:
            if i not in dictionary:
                print(0)
            else:
                print(1)

a = Solution()
a.findIncludingNumber()