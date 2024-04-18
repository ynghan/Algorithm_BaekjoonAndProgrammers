def solution(num_list, n):
    answer = []
    # 정수 리스트 num_list, 정수 n
    i = 0
    while len(num_list) > n * i :
        answer.append(num_list[n * i])
        i += 1
    
    return answer