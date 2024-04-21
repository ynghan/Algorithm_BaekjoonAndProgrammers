def solution(order):
    answer = 0
    while order > 0:
        k = order % 10
        if k == 3 or k == 6 or k == 9:
            answer += 1
        order = int(order/10)
        
    return answer