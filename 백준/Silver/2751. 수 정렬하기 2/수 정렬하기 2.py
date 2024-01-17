"""
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력 : 첫 째줄에 N개, 둘 째줄부터 N개의 줄에 수
출력 : 첫 째줄부터 N개의 줄에 오름차순으로 정렬한 결과 한줄에 하나의 수
"""
import sys

input = sys.stdin.readline

class Solution:
    def sort(self):
        N = int(input().strip())
        arr = [int(input().strip()) for _ in range(N)]
        # arr = [int(input().strip())]
        arr.sort()

        for j in range(N):
            print(arr[j])

a = Solution()
a.sort()