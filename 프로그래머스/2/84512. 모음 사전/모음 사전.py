def solution(word):
    answer = 0
    weight = [781, 156, 31, 6, 1]
    dic = {'A':1, 'E':2, 'I':3, 'O':4, 'U':5}
    for i in range(len(word)):
         answer += weight[i] * (dic[word[i]]-1) + 1
    return answer



# AAAAA AAAAE AAAAI AAAAO AAAAU -> 5 6 7 8 9 {1}
# AAAA AAAE AAAI AAAO AAAU -> 4 10 16 22 28 {6}
# AAA AAE AAI AAO AAU -> 3 34 65 86 117 {31}
# AA AE -> 2 158 {156}
# {781}
# AAUUU