def solution(rsp):
    answer = ''
    for i in rsp:
        if i == "0":
            answer += str(5)
        elif i == "2":
            answer += str(0)
        else:
            answer += str(2)
    return answer