def solution(s):
    li = list(s.split())
    an = []
    answer = []
    for i in li:
        an.append(int(i))
    an.sort()
    answer.append(str(an[0]))
    answer.append(str(an[-1]))
    return ' '.join(answer)