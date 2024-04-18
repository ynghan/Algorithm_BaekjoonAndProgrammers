# 정수 배열 arr, query
def solution(arr, query):
    answer = []
    for i in range(len(query)):
        if i % 2 == 0:
            # query[i] 뒷부분 삭제
            arr = arr[:query[i]+1]
        else:
            # query[i] 앞부분 삭제
            arr = arr[query[i]:]
    return arr