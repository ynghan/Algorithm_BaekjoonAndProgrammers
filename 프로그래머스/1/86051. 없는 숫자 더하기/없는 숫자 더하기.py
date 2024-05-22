def solution(numbers):
    find = set()
    for i in numbers:
        find.add(i)
    
    return 45 - sum(find)