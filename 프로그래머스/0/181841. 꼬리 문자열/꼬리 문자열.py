def solution(str_list, ex):
    li = []
    for i in str_list:
        if ex not in i :
            li.append(i) 
            
    return ''.join(li)