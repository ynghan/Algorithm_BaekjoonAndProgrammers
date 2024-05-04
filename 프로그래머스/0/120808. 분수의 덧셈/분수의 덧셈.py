def divide(a, b):
    min = a if a < b else b 
    for i in range(2, min+1):
        while True:
            if a % i == 0 and b % i == 0:
                a //= i
                b //= i
            else:
                break;
    return a, b


def solution(numer1, denom1, numer2, denom2):
    answer = []
    
    numer3 = numer1 * denom2 + numer2 * denom1
    numer, denom = divide(numer3, denom1 * denom2)
    
    answer.append(numer)
    answer.append(denom)
    
    return answer