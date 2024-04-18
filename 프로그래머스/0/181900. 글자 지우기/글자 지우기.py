# 문자열 my_string
# 정수배열 indices

def solution(my_string, indices):
    answer = ''
    a = list(my_string)
    for i in indices:
        a[i] = ''
    return ''.join(a)