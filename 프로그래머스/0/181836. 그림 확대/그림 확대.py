def solution(picture, k):
    answer = []
    for i in picture:
        for _ in range(k):
            a = ""
            for j in i:
                for _ in range(k):
                    a += j
            answer.append(a)
        
                
    return answer