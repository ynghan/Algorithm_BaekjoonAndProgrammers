def solution(s, n):
    answer = ''
    for i in s:
        if 97 <= ord(i) <= 122:
            k = ((ord(i)+n) - 97)%26
            answer += chr(k+97)
        elif 65 <= ord(i) <= 90:
            k = ((ord(i)+n) - 65)%26
            answer += chr(k+65)
        else:
            answer += i
    return answer