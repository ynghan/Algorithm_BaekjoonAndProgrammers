def solution(arr1, arr2):
    answer = 0
    # len(arr1) == len(arr2): sum(arr1), sum(arr2)
    if len(arr1) == len(arr2):
        if sum(arr1) == sum(arr2):
            return 0
        elif sum(arr1) > sum(arr2):
            return 1
        else:
            return -1
    else:
        if len(arr1) > len(arr2):
            return 1
        else:
            return -1