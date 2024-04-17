def solution(x1, x2, x3, x4):
    answer = True
    answer = True if x1 or x2 else False
    temp = True if x3 or x4 else False
    answer = True if answer and temp else False
    return answer