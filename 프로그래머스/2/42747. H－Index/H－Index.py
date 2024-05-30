def solution(citations):
    answer = 0
    
    for i in range(max(citations)+1):
        count = 0 
        for j in range(len(citations)):
            if citations[j] >= i:
                count += 1
        if i <= count:
            answer = i
    return answer