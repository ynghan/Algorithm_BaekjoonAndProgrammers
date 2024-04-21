def solution(A, B):
    k = 0
    while k <= len(A):
        if A == B:
            return k
        A = A[-1]+A[:-1]
        print(A)
        k += 1
    
    return -1