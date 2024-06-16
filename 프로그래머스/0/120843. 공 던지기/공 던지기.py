def solution(numbers, k):
    answer = 0
    k -= 1
    k *= 2
    
    idx = k % len(numbers)
    answer = numbers[idx]
    return answer