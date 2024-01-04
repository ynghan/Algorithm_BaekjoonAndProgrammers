# 문제 : https://www.acmicpc.net/problem/10866


from collections import deque
from sys import stdin

input = stdin.readline

n = int(input())
d = deque()

for _ in range(n):
    order = input().split()
    cmd = order[0]

    # push_front X: 정수 X를 덱의 앞에 넣는다.
    if cmd == "push_front":
        x = order[1]
        d.appendleft(int(x))

    # push_back X : 정수 X를 덱의 뒤에 넣는다.
    elif cmd == "push_back":
        x = order[1]
        d.append(int(x))
    # pop_front : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.
    # 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif cmd == "pop_front":
        if d:
            print(d.popleft())
        else:
            print(-1)
    # pop_back : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.
    # 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif cmd == "pop_back":
        if d:
            print(d.pop())
        else:
            print(-1)
    # size : 덱에 들어있는 정수의 개수를 출력한다.
    elif cmd == "size":
        print(len(d))
    # empty : 덱이 비어있으면 1을, 아니면 0을 출력한다.
    elif cmd == "empty":
        if d:
            print(0)
        else:
            print(1)
    # front : 덱의 가장 앞에 있는 정수를 출력한다.
    # 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif cmd == "front":
        if d:
            print(d[0])
        else:
            print(-1)
    # back : 덱의 가장 뒤에 있는 정수를 출력한다.
    # 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    elif cmd == "back":
        if d:
            print(d[-1])
        else:
            print(-1)