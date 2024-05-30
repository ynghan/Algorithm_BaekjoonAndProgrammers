def solution(numbers):
    answer = []
    numbers.sort()
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i < j:
                if numbers[i] + numbers[j] in answer:
                    continue
                else:
                    answer.append(numbers[i] + numbers[j])
    answer.sort()
    return answer