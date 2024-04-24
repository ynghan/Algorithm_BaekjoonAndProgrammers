def solution(my_string):
    answer = 0
    strng = ""
    for i in my_string:
        if 97 <= ord(i) <= 122 or 65 <= ord(i) <= 90:
            strng += " "
        else:
            strng += i
    for k in strng.strip().split():
        answer += int(k)
    return answer
    # answer = '+'.join(strng.strip().split())
    # return eval(answer)