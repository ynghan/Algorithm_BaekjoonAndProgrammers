def solution(bin1, bin2):
    answer = ''
    a = int(bin1,2)
    b = int(bin2,2)
    return str(bin(a+b))[2:]