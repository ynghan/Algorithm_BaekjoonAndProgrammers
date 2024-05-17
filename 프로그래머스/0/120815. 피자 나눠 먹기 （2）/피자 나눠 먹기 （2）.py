def lcm(a, b):
    for i in range(max(a, b), (a * b) + 1):
        if i % a == 0 and i % b == 0:
            return i

def solution(n):
    answer = 0
    
    # 6과 n의 최소공배수 찾기
    m = lcm(n,6)
    # 공배수 // n
    return m // 6