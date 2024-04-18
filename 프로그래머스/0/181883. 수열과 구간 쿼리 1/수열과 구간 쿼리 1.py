def solution(arr, queries):
    answer = []
    # 정수 배열 arr
    # 2차원 정수 배열 queries
    for s, e in queries:
        # 각 query마다 순서대로 s <= i <= e인 모든 i에 대해 arr[i]에 1을 더합니다.
        for i in range(s,e+1):
            arr[i] += 1
            
    return arr