def solution(numLog):
    
    key = { 1: 'w', -1: 's', 10: 'd', -10: 'a' }
    
    answer = ''
    length = len(numLog) - 1
    for i in range(length):
        answer += key[numLog[length - i] - numLog[length - i - 1]]
    answer = answer[::-1]
    return answer