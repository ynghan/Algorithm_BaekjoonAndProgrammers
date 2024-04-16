# 입력값 받기
# int(f"{a}{b}")와 2*a*b 비교하기

def solution(a, b):
    answer = 0
    if int(f"{a}{b}") > 2*a*b:
        answer = int(f"{a}{b}")
    else:
        answer = 2*a*b
    
    return answer