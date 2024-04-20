
def solution(arr):
    x = 0
    
    while 2**x < len(arr):
        x += 1
        
    return arr + [0] * (2**x - len(arr))