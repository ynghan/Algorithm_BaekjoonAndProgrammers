def solution(num_list, n):
    answer = []
    
    for i in range(len(num_list)//n):
        bucket = []
        for j in range(n):
            bucket.append(num_list[i*n+j])
        answer.append(bucket)
            
    return answer