def solution(s):
    if len(s) != 6 and len(s) != 4:
        return False
    for i in s:
        if i.isdigit():
            continue
        else:
            return False
    return True