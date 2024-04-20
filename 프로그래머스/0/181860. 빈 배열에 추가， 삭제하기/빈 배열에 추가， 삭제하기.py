def solution(arr, flag):
    X = []
    
    for i, b in enumerate(flag):
        if b :
            for _ in range(arr[i] * 2):
                X.append(arr[i])
        else:
            for _ in range(arr[i]):
                X.pop()
    return X