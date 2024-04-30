def rotate(arr, x1, y1, x2, y2):
    min_x = x1-1
    min_y = y1-1
    max_x = x2-1
    max_y = y2-1
    curr_x = min_x
    curr_y = min_y
    trace = []
    # 다음 값을 tmp에 넣어두고 값을 넣고
    before = 0
    after = arr[curr_x][curr_y]
    while 1:
        before = after  # 이 값을 다음 값에 넣어야 함.
        if curr_x == min_x and curr_y < max_y:
            # 오른쪽으로 이동
            curr_y += 1
        elif curr_x < max_x and curr_y == max_y:
            # 아래로 이동
            curr_x += 1
        elif curr_x == max_x and curr_y > min_y:
            # 왼쪽으로 이동
            curr_y -= 1
        elif curr_x > min_x and curr_y == min_y:
            # 위로 이동
            curr_x -= 1
        after = arr[curr_x][curr_y]
        arr[curr_x][curr_y] = before
        trace.append(before)

        if curr_x == min_x and curr_y == min_y:
            break

    return min(trace)


def solution(rows, columns, queries):
    procession = [[(i + 1) + columns * (j) for i in range(columns)] for j in range(rows)]  # 행렬
    answer = []  # 최소값들의 리스트

    for x1,y1,x2,y2 in queries:
        answer.append(rotate(procession,x1,y1,x2,y2))
    return answer