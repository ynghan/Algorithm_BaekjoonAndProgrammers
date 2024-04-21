def solution(array, n):
    tmp = array[0]
    diff = abs(n-array[0])
    
    for v in array:
        if diff > abs(n-v):
            diff = abs(n-v)
            tmp = v
        elif diff == abs(n-v):
            if tmp > v:
                tmp = v
            
    return tmp