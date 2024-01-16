import sys

input = sys.stdin.readline

class Solution():
    def problem(self):

        N = int(input())
        board = [list(input().rstrip()) for _ in range(N)]

        # 완전 탐색
        # 일반
        def dfs(i, j, color, visited):
            dx = [1, -1, 0, 0]
            dy = [0, 0, 1, -1]
            stack = [(i, j)]
            while stack:
                x, y = stack.pop()
                if visited[x][y] == -1:
                    visited[x][y] = 1
                    for k in range(4):
                        nx, ny = x + dx[k], y + dy[k]
                        if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == -1 and board[nx][ny] == color:
                            stack.append((nx,ny))

        # 방문 기록 리스트
        visited_general = [[-1] * N for _ in range(N)]
        visited_blined = [[-1] * N for _ in range(N)]

        general_count = 0
        blined_count = 0

        for i in range(N):
            for j in range(N):
                if visited_general[i][j] == -1:
                    dfs(i, j, board[i][j], visited_general)
                    general_count += 1

        for i in range(N):
            for j in range(N):
                if board[i][j] == 'R' or board[i][j] == 'G':
                    board[i][j] = 'R'

        for i in range(N):
            for j in range(N):
                if visited_blined[i][j] == -1:
                    dfs(i, j, board[i][j], visited_blined)
                    blined_count += 1

        return general_count, blined_count

import sys

a = Solution()
count1, count2 = a.problem()
print(count1, count2)


