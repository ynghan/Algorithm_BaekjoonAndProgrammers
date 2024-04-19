def solution(myString, pat):
    answer = 0
    for start in range(0, len(myString)-len(pat)+1):
        if pat == myString[start:start+len(pat)]:
            answer += 1
    return answer