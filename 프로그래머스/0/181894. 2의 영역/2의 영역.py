def solution(arr):
    answer = []
    index = []
    
    for idx in range(len(arr)):
        if arr[idx] == 2:
            index.append(idx)
    
    if len(index) >= 2:
        return arr[index[0]:index[-1]+1]
    elif len(index) == 1:
        return arr[index[0]:index[0]+1]
    else:
        return [-1]