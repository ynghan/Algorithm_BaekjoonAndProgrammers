# arr : 서로 다른 k개의 수
# 
def solution(arr, k):
    answer = []
    idx = 0
    while idx < len(arr) and len(answer) < k:
        if arr[idx] not in answer:
            answer.append(arr[idx])
        idx += 1
                
    while k > len(answer):
        answer.append(-1)
        
    return answer