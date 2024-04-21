def solution(n):
    answer = 0
    while n > 0:
        k = n % 10
        answer += k
        n //= 10
    return answer