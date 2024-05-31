# 문자열 string, 정수 n
# 인덱스 n번째 글자를 기준으로 오름차순 정렬

def solution(strings, n):
    return sorted(strings, key=lambda x: (x[n], x))