def solution(before, after):
    answer = 0
    b = list(before)
    a = list(after)
    
    for be in b:
        if be in a:
            a.remove(be)
    return 1 if not a else 0