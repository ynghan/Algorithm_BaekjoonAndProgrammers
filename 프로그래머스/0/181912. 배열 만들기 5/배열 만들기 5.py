def solution(intStrs, k, s, l):
    answer = []
    
    for num in intStrs:
        n = int(str(num)[s:s+l])
        print(n)
        if n > k:
            answer.append(n)

    return answer