# a : 97
# P : 80
# ABCD EFG HIJK LMN OP
def solution(my_string):
    answer = [0]*52
    print(ord("A"))
    print(ord("Z"))
    print(ord("a"))
    print(ord("z"))
    list = []
    for i in my_string:
        if 65 <= ord(i) <= 90:
            answer[ord(i)-65] += 1
        elif 97 <= ord(i) <= 122:
            answer[ord(i)-97+26] += 1
    return answer 


[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,2,0,1,0,0,3,1,0]
[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,2,0,1,0,0,3,1,0,0,0,0,0,0,0]
