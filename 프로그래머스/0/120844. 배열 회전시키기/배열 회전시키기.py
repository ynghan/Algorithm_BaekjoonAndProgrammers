from collections import deque

def solution(numbers, direction):
    answer = []
    dq = deque()
    for i in numbers:
        dq.append(str(i))

    if direction == "right":
        dq.rotate(1)
    else:
        dq.rotate(-1)
    
    for i in dq:
        answer.append(int(i))
    
    return answer