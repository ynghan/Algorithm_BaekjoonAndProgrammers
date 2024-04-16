# 주사위 3개
# 3개의 주사위를 굴렸을 때 값이 a, b, c 
# a b c 모두 값이 다름 -> a + b + c
# 두 값이 동일, 나머지 값 다름 -> (a + b + c) * (a**2 + b**2 + c**2)
# 모든 값 동일 -> (a + b + c) * (a**2 + b**2 + c**2) * (a**3 + b**3 + c**3)

def three(a, b, c):
    return two(a,b,c) * (a**3 + b**3 + c**3)

def two(a, b, c):
    return one(a,b,c) * (a**2 + b**2 + c**2)

def one(a, b, c):
    return a + b + c

def solution(a, b, c):
    answer = 0
    if a == b: # 2개 동일
        if b == c: # a == b == c
            answer = three(a,b,c)
        else: # a == b != c
            answer = two(a,b,c)
    else:
        if b == c: # a != b == c
            answer = two(a,b,c)     
        else: # a != b != c
            answer = two(a,b,c) if a == c else one(a,b,c)
    
    return answer