def solution(s):
    # 스택 초기화
    stack = []
    
    # 문자열 s를 순회하며 스택을 활용하여 중복 문자 처리
    for char in s:
        # 스택이 비어있지 않고, 현재 문자가 스택의 마지막 문자와 같다면 중복된 것이므로 스택에서 제거
        if stack and stack[-1] == char:
            stack.pop()
        else:
            # 중복되지 않은 문자는 스택에 추가
            stack.append(char)
    
    # 스택이 비어있다면 모든 중복 문자가 제거된 것이므로 1 반환, 그렇지 않다면 0 반환
    return 1 if not stack else 0
