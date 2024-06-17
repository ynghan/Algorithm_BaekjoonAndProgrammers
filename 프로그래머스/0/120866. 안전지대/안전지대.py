def solution(board):
    n = len(board)
    answer = n * n
    dx = [-1,0,1,-1,1,-1,0,1]
    dy = [-1,-1,-1,0,0,1,1,1]
    for x in range(n):
        print(board[x])
    
    print()
    for x in range(n):
        for y in range(n):
            if board[x][y] == 1:
                for i,j in zip(dx,dy):
                    if 0 <= x+i < n and 0 <= y+j < n and board[x+i][y+j] != 1:
                        board[x+i][y+j] = -1
    
    for x in range(n):
        print(board[x])
    
    for x in range(n):
        for y in range(n):
            if board[x][y] == 1 or board[x][y] == -1:
                answer -= 1
    return answer
