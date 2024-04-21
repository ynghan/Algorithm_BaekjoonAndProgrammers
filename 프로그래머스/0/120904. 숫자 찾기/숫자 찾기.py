def solution(num, k):
    answer = 0
    for i, v in enumerate(str(num)):
        print(i,v)
        if int(v) == k:
            return i+1
    return -1