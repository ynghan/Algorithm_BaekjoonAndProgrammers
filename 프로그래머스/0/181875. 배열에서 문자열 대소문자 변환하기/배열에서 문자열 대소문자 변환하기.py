def solution(strArr):
    answer = []
    for i, v in enumerate(strArr):
        answer.append(v.lower()) if i % 2 == 0 else answer.append(v.upper())
    return answer