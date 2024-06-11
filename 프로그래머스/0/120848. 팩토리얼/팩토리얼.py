def solution(n):
    answer = 0
    
    for i in range(1, 11):
        fact = 1
        for j in range(1, i+1):
            fact *= j
        if fact > n:
            return i-1
        elif fact == n:
            return i
    return 1
            
    
    
    
    return answer