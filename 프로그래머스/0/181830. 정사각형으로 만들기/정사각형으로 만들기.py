def solution(arr):
    for i in arr:
        if len(i) < len(arr):
            for _ in range(len(arr)-len(i)):
                i.append(0)
        elif len(arr) < len(i):
            for _ in range(len(i)-len(arr)):
                arr.append([0 for _ in range(len(i))])
        
    return arr