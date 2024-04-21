def solution(array):

    answer = []
    max = array[0]
    idx = 0
    for i,v in enumerate(array):
        if max < v:
            max = v
            idx = i
    
    return [max, idx]
