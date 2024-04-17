def solution(n, k):
    answer = []
    a = k
    while k <= n:
        answer.append(k)
        k += a
        
    return answer