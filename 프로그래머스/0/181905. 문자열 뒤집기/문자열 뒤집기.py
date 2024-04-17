def solution(my_string, s, e):
    a = list(my_string)
    b = list(my_string[s:e+1])
    rev = list(reversed(b))
    for i in range(e - s + 1):
        a[s+i] = rev[i]
    return ''.join(a)
