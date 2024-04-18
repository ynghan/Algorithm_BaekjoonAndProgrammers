def solution(arr):
    count = 0
    length = len(arr)


    while True:
        after = [0] * length
        for i, k in enumerate(arr):
            if k >= 50 and k % 2 == 0:
                after[i] = int(k / 2)
            elif k < 50 and k % 2 == 1:
                after[i] = int(k * 2 + 1)
            else:
                after[i] = arr[i]

        if arr == after:
            break
        else:
            count += 1
            arr = after

    return count