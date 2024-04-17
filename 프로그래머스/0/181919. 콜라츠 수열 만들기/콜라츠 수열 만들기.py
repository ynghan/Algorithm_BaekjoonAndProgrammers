def solution(n):
    answer = []
    # 모든 자연수 x에 대해서 
    # 현재 값이 x이면 x가 짝수일 때는 2로 나누고, x가 홀수일 때는 3 * x + 1로 바꾸는 계산
    # 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제
    # 위 과정을 거쳐간 모든 수를 기록한 수열을 콜라츠 수열
    # 1000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다
    # 1000 보다 작거나 같은 양의 정수 n이 주어질 때, 초기값이 n인 콜라츠 수열을 return하는 solution 함수
    while n != 1:
        answer.append(n)
        if n % 2 == 0:
            n /= 2
        else:
            n = 3 * n + 1
    answer.append(1)
    return answer