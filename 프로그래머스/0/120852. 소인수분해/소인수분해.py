def solution(n):
    answer = []
    divide_num = 2
    while n != 1:
        if n % divide_num == 0:
            if divide_num not in answer:
                answer.append(divide_num)
            n //= divide_num
        else:
            divide_num += 1
    
            
    return answer