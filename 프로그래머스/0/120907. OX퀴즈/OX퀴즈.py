def solution(quiz):
    answer = []
    for i in quiz:
        a = i.replace("=", "==")
        if eval(a):
            answer.append("O")
        else:
            answer.append("X")
    return answer