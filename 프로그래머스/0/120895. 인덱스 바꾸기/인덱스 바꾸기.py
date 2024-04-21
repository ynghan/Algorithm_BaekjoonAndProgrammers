def solution(my_string, num1, num2):
    answer = ''
    str = list(my_string)
    
    tmp = str[num1]
    str[num1] = str[num2]
    str[num2] = tmp
    
    return ''.join(str)