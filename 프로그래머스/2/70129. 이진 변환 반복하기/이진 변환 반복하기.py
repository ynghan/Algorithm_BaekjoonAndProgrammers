def solution(s):
    answer = []
    zero_count = 0
    circle = 0
    while s != "1":
        press = s.replace("0","")
        length = len(press)
        zero_count += len(s) - length
        binary_length = format(length, 'b')
        s = binary_length
        circle += 1
    answer.append(circle)
    answer.append(zero_count)
    return answer