def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        # i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
        for i in range(s,e+1):
            if i % k == 0: 
                arr[i] += 1
            
    return arr