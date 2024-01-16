import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

for n in range(N):
    I = int(input())

    x, y = map(int, input().split())


    x_, y_ = map(int, input().split())


    def bfs(x, y, x_, y_):
        dx = [-2, -2, -1, -1, 1, 1, 2, 2]
        dy = [1, -1, 2, -2, 2, -2, -1, 1]

        queue = deque()
        queue.append((x, y))

        visited = [[-1 for _ in range(I)] for _ in range(I)]
        visited[x][y] = 0

        while queue:
            x, y = queue.popleft()
            if x == x_ and y == y_:
                return visited[x][y]
            for i in range(8):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < I and 0 <= ny < I and visited[nx][ny] == -1:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
        return -1

    result = bfs(x,y,x_,y_)

    print(result)

