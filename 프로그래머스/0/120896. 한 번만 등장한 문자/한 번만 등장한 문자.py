def solution(s):
    answer = []
    for i,v in enumerate(s):
        if v not in s[:i]+s[i+1:]:
            answer.append(v)
    answer.sort()
    return ''.join(answer)