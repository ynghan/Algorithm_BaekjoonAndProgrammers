def solution(myString, pat):
    answer = ''

    myString1 = myString.lower()
    pat1 = pat.lower()

    idx = 0
    for start in range(len(myString1)):
        for end in range(start + len(pat1), len(myString1) + 1):
            if pat1 == myString1[start:end]:
                idx = end

    return myString[:idx]