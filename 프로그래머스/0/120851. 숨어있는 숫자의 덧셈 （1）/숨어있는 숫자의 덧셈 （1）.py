def solution(my_string):
    arr = 0
    for i in my_string:
        if i.isdigit():
            arr += int(i)
    return arr