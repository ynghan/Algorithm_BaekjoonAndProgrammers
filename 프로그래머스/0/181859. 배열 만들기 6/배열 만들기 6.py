def solution(arr):
    stk = []
    i = 0
    
    while i < len(arr): #i = 0 ~ 4
        if not stk: # stk가 빈 리스트 일 경우
            stk.append(arr[i])
        else: # stk가 빈 리스트가 아닐 경우
            if stk[-1] == arr[i]: # stk 마지막 요소와 arr[i]의 요소 값이 동일한 경우
                stk.pop()
            else: # 아닌 경우
                stk.append(arr[i])
        i += 1
        
    if not stk:
        return [-1]
    return stk