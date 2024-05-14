def count_divisors(number, limit):
    if number == 1:
        return 1

    result = 0

    for num in range(1, int(number**(1/2)) + 1):
        if number % num == 0:
            if num * num == number:
                result += 1
            else:
                result += 2

    if result > limit:
        return 0

    return result

def solution(number, limit, power):
    
    answer = 0
    divisors = []

    for num in range(1, number+1):
        result = count_divisors(num, limit)
        if result == 0:
            divisors.append(power)
        else:
            divisors.append(result)

    return sum(divisors)