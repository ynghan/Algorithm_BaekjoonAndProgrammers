def solution(strArr):
    
    answer = [0] * len(strArr)
    for i in range(len(strArr)):
        answer[len(strArr[i])] += 1
        
    return max(answer)