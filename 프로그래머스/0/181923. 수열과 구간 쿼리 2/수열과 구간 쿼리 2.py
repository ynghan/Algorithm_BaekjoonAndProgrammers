def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        list = []
        # (1) s <= i <= e
        # (2) arr[i] > k 를 만족
        # (3) 최소값 arr[i]
        for i in range(s,e+1):
            if arr[i] > k:
                list.append(arr[i])
        if list:
            answer.append(min(list))
        else:
            answer.append(-1)
    return answer