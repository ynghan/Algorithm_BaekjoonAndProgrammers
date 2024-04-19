def solution(myString, pat):

    answer = []
    for i in myString:
        if i == "A":
            answer.append("B")
        else:
            answer.append("A")
        
    swtch = ''.join(answer)
    if pat in swtch:
        return 1
    else:
        return 0