def solution(my_string):
    answer = []
    s = my_string.lower()
    for i in s:
        answer.append(i)
    answer.sort()
    return ''.join(answer)