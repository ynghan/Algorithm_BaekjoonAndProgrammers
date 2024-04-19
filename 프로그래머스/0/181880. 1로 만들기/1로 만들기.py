def solution(num_list):
    answer = 0

    for num in num_list:
        count = 0
        while num != 1:
            if num % 2 == 0:
                num = int(num/2)
            else:
                num = int((num - 1)/2)
            count += 1
        answer += count
    return answer