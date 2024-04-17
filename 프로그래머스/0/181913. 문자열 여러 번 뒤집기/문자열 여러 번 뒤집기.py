def solution(my_string, queries):
    answer = ''
    
    li = list(my_string)

    for s, e in queries:    
        arr = li[s:e+1]
        rev = list(reversed(arr))
        for i in range(s, e+1):
            li[i] = rev[i-s]
            
    answer = ''.join(li)
    return answer