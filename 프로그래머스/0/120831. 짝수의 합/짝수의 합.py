def solution(n):
    answer = [i for i in range(2,n+1,2)]
    print(answer)
    return sum(answer)