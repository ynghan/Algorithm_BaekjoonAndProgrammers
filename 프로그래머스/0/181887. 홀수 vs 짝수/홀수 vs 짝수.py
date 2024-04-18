def solution(num_list):
    answer = 0
    even = 0
    odd = 0
    
    for i, k in enumerate(num_list):
        if i % 2 == 0:
            even += k
        else:
            odd += k
    if even > odd:
        answer = even
    else:
        answer = odd
    return answer