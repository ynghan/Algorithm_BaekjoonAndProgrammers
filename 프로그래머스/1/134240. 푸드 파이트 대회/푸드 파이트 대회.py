

def solution(food):
    half = []
    for idx, num in enumerate(food):
        if idx == 0:
            continue
        else:
            for _ in range(num//2):
                half.append(str(idx))
    return ''.join(half) + "0" + ''.join(half[::-1])