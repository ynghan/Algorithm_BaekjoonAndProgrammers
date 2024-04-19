def solution(num_list):
    answer = 0

    # 모든 원소들의 합
    s = sum(num_list)
    # 모든 원소들의 곱
    mul = 1
    for i in num_list:
        mul *= i

    return s if len(num_list) >= 11 else mul