# 홀짝 구분
# 홀 -> 이하의 모든 홀수 합 반환
# 짝 -> 이하의 모든 짝수의 제곱의 합 반환

def solution(n):
    answer = 0
    if n % 2 == 0: # 짝수
        for i in range(int(n / 2)+1):
            answer += (i*2)**2
    else: # 홀수
        for i in range(int(n / 2)+1):
            answer += (2*i+1)
    return answer