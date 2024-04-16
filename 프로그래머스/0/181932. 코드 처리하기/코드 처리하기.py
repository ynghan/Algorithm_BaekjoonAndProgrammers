# 문자열 code
# code를 앞에서부터 읽는다.
# 문자가 1이면 mode를 바꾼다.
# mode에 따라 code를 읽으면서 문자열 ret을 만든다.
# mode는 0과 1이 있다.
# idx를 0에서 code - 1까지 1씩 키워나가며 code[idx]의 값에 따라 다음과 같이 행동한다.


def solution(code):
    
    ret = ''
    mode = 0
    for idx in range(len(code)):
        if code[idx] == '1':
            mode = 1 - mode
        else:
            if idx % 2 == mode:
                ret += code[idx]
    if ret == '':
        return 'EMPTY'
    return ret




