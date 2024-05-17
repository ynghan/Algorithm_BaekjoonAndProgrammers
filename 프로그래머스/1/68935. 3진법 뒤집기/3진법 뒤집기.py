def solution(n):
    answer = []
    result = 0
    
    # 1. 3진수 표현 방법  # 1 3 9 27 81
    
    i = 0
    while n > 0:
        val = n // 3
        mod = n % 3
        answer.append(mod)
        n = val
    

    print(answer)
    
    # 10진법으로 표현
    for i in range(len(answer)):
        result += answer[i]*(3**(len(answer)-1-i))
    
    
    return result

# 10 = 1010

