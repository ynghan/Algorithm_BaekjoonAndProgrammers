"""
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어짐.
회원들의 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬.
"""
import sys

input = sys.stdin.readline

class Solution():
    def ageSort(self):
        N = int(input().rstrip())
        judge = list()
        for i in range(N):
            age, name = input().rstrip().split(" ")
            judge.append([int(age), name])
        """
        첫 번째 요소의 값이 같을 경우, 입력한 순서대로 두 번째 요소를 정렬하는 방법
        """
        judge.sort(key=lambda x: x[0])

        """
        출력 형식
        """
        for age, name in judge:
            print(age, name)

a = Solution()
a.ageSort()

