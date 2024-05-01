def solution(n):
    # n*n 크기의 2차원 배열 생성 후 0으로 초기화
    matrix = [[0]*n for _ in range(n)]
    # 시작 위치와 방향, 현재 숫자 초기화
    x, y = -1, 0
    number = 1
    # 아래, 오른쪽, 대각선 위 이동을 위한 방향 벡터 설정
    dx = [1, 0, -1]
    dy = [0, 1, -1]
    
    # 각 변의 길이를 설정
    for i in range(n):
        for j in range(i, n):
            # 방향 전환: 아래 -> 우 -> 상 -> 아래 ... 순으로 반복하므로, 3으로 나눈 나머지를 이용
            nx = x + dx[i % 3]
            ny = y + dy[i % 3]
            # 다음 위치에 현재 숫자를 채우고, 현재 숫자를 1 증가
            matrix[nx][ny] = number
            number += 1
            # 위치 업데이트
            x, y = nx, ny
    # 2차원 배열을 1차원 리스트로 변환하여 반환
    answer = [x for row in matrix for x in row if x != 0]
    return answer