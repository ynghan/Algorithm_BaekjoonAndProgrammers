def solution(num_list):
    answer = 0
    mul = 1
    summ = 0
    for i in range(len(num_list)):
        mul *= num_list[i]
        summ += num_list[i]
    return  1 if mul < summ**2 else 0