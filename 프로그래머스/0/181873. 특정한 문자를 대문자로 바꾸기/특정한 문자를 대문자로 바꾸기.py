# my_string : 소문자 문자열
# alp : 소문자 1글자

def solution(my_string, alp):
    answer = []
    for i in my_string:
        answer.append(i.upper()) if i == alp else answer.append(i)
    return ''.join(answer)