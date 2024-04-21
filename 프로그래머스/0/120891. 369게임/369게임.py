def solution(order):
    answer = 0
    while order > 0:
        k = order % 10
        if k % 3 == 0 and k != 0:
            answer += 1
        order = int(order/10)
        
    return answer