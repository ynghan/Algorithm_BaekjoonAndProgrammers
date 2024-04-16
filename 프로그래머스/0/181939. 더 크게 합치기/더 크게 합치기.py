# 정수 a와 b를 입력받기
# 문자열로 변환하기 
# a+b, b+a 문자열 더하기
# 정수형 변환하기 
# 서로 비교하기
# 큰 수 반환 
def solution(a, b):
    answer = 0
    str1 = str(a) + str(b)
    str2 = str(b) + str(a)
    if int(str1) > int(str2) :
        answer = int(str1)
    else:
        answer = int(str2)
    
    return answer