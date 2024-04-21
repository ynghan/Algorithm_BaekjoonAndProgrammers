def solution(n):
    answer = []
    
    for i in range(n): # n번 append 해야함
        a = []
        for j in range(n):
            b = 1 if i == j else 0
            a.append(b)
        answer.append(a)
    
    return answer