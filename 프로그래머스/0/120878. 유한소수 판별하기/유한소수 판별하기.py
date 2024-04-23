def solution(a, b):
    answer = 0
    for i in range(1, a+1):
        if a % i == 0 and b % i == 0:
            a //= i
            b //= i
    
    # 2나 5로 나누었을 경우 1이 안되는 것.
    while b > 1:
        if b % 2 == 0:
            b //= 2
        elif b % 5 == 0:
            b //= 5
        else:
            return 2
        
    return 1