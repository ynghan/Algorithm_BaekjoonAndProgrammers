def solution(numbers):
    
    arr = sorted(numbers,reverse=True)
    
    return arr[0] * arr[1]