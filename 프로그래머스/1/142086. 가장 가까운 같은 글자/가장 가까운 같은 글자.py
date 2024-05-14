def solution(s):
    check = set()
    answer = []
    for i in range(len(s)):
        if s[i] not in check:
            check.add(s[i])
            answer.append(-1)
        else:
            for j in range(i-1,-1,-1):
                if s[j] == s[i]:
                    answer.append(i-j)
                    break
    print(check)
    
    return answer