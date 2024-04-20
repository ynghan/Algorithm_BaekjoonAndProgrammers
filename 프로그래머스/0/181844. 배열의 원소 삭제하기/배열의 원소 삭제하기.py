def solution(arr, delete_list):
    li = []
    for i in arr:
        if i not in delete_list:
            li.append(i)
    return li