def solution(food):
    answer = ''
    for i,n in enumerate(food[1:]):
        answer += str(i+1) * (n//2) # += 를 뺏네요
        
        
    return answer + "0" + answer[::-1]