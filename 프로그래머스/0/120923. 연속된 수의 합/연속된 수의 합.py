def solution(num, total):
    answer = []
    for i in range(num):
        answer.append(i)
        
    while sum(answer) != total:
        if sum(answer) < total:
            for i in range(len(answer)):
                answer[i] += 1
        else:
            for i in range(len(answer)):
                answer[i] -= 1
    return answer