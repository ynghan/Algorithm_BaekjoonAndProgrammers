def solution(s):
    answer = ""
    k = 0
    n = ""
    for i in s:
        if i == " ":
            k = 0
            n = " "
            
        else:
            if k == 0:
                k = 1
                n = i.upper()
            else:
                k = 0
                n = i.lower()
        answer += n
    return answer
            