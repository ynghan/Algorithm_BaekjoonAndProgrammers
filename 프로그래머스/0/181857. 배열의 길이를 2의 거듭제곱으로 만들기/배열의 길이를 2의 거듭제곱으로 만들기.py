
def solution(arr):
    x = 1    
    while x < len(arr):
        x *= 2
    return arr + [0] * (x - len(arr))
