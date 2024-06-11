def solution(emergency):
    answer = []
    sort_emergency = sorted(emergency, reverse=True)
    
    for i in range(len(emergency)):
        for j in range(len(sort_emergency)):
            if sort_emergency[j] == emergency[i]:
                answer.append(j+1)
    
    return answer