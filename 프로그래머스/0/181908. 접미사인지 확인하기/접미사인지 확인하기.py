def solution(my_string, is_suffix):
    answer = 0
    return 1 if is_suffix == my_string[-len(is_suffix):] else 0
