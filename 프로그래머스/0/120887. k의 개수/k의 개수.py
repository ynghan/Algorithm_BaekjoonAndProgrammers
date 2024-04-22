def solution(i, j, k):
    answer = 0
    for n in range(i,j+1):
        for m in str(n):
            if m in str(k):
                answer += 1
    return answer