from itertools import combinations
def solution(balls, share):
    p = 1
    q = 1
    for i in range(share):
        p *= (balls) - i
    for j in range(share,1,-1):
        q *= j
    return p // q