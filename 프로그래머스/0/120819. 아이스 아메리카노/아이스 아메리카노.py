def solution(money):
    count = money//5500
    answer = [count, money - count*5500]
    return answer