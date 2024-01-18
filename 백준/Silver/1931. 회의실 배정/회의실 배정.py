# S1 1931
# https://www.acmicpc.net/problem/1931

"""
N개의 회의에 대하여 회의실 사용표를 만듬
각 회의 I에 대해 시작 시간과 끝나느 시간이 주어짐

(1) 회의의 수 N
(2 ~ N+1) 회의 정보

사용할 수 있는 회의의 최대 개수
"""

"""
회의가 끝나는 시간이 빠를수록 더 많은 회의를 배정할 수 있는 가능성이 높아진다.
"""
import sys


class Solution:
    def meetingRoom(self):
        input = sys.stdin.readline

        N = int(input())

        meetings = [tuple(map(int, input().split())) for _ in range(N)]

        meetings.sort(key=lambda x: (x[1], x[0]))

        max_value = 0
        end_time = 0
        
        for start, end in meetings:
            if start >= end_time:
                max_value += 1
                end_time = end
        
        print(max_value)

Solution().meetingRoom()