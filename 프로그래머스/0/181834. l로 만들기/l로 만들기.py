def solution(myString):
    answer = []
    for i in myString:
        if ord(i) < ord("l"):
            answer.append("l")
        else:
            answer.append(i)
    return ''.join(answer)