def solution(numbers, n):
    answer = 0
    sum = 0
    for i in numbers:
        if sum <= n:
            sum += i
    return sum