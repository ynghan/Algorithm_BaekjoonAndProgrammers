# 1. 입력 문자열 my_string을 k번 반복으로 더하기 연산

def solution(my_string, k):
    answer = ''
    for _ in range(k):
        answer += my_string
    return answer