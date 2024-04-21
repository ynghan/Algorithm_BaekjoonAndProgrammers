def solution(cipher, code):
    answer = ''
    for i, v in enumerate(cipher):
        if (i+1) % code == 0:
            answer += v
    return answer