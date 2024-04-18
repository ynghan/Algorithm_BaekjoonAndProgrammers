def solution(str_list):
    answer = []
    for i, k in enumerate(str_list):
        if k == "l":
            return str_list[:i]
        elif k == "r":
            return str_list[i+1:]
    return answer