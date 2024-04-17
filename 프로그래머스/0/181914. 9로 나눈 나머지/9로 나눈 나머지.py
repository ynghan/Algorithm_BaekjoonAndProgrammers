# 음이 아닌 정수를 9로 나눈 나머지 
# 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지
def solution(number):
    answer = 0
    for i in str(number):
        print(i)
        answer += int(i) % 9
    answer %= 9
    return answer