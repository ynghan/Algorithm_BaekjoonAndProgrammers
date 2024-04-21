def solution(n):
    # 제곱수인지 판별하는 방법
    # t**2 == n 인 자연수 t가 존재한다면, 1
    for t in range(1, int(n**(1/2) + 1)):
        if t**2 == n:
            return 1
    return 2