# 정수 배열 arr
# 2차원 정수 배열 queries
# queries의 각 원소를 query
# query는 [i,j] 꼴 -> arr[i]와 arr[j] 스위칭

def solution(arr, queries):
    answer = []
    for query in queries:
        temp = arr[query[0]]
        arr[query[0]] = arr[query[1]]
        arr[query[1]] = temp
    
    return arr