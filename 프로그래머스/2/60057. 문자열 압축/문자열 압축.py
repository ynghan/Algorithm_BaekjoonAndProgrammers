def solution(s):
    # 압축한 문자열 길이를 담을 배열을 생성하여 나중에 최소값을 구할것이다.
    zip_length = []

    for i in range(1, len(s) // 2 + 1):
        # 각 원소들을 순회하며, 다음 원소와 일치하는지 검사한다.
        # 중복 횟수 변수를 만들자.
        count = 1
        idx = 0
        string = ""
        # 인덱스가 일치하는지 안하는지에 따라 불연속적으로 변하므로 while로 돌린다.
        while idx <= len(s) - i + 1:
            # 만약 i개의 문자가 다음 i개의 문자와 일치한다면
            if s[idx:idx + i] == s[idx + i:idx + 2 * i]:
                count += 1
            else:
                if count != 1:
                    string += str(count)
                    string += ''.join(s[idx:idx + i])
                    count = 1
                else:
                    string += ''.join(s[idx:idx + i])

            idx += i
        string += ''.join(s[idx:])
        zip_length.append(len(string))

    return min(zip_length) if len(zip_length) > 1 else 1