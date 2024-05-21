def solution(new_id):
    answer = []
    change = ""
    # 가능한 요소
    check = ["-", "_", "."]
    # 연속된 마침표 세기
    dot_count = 0
    
    # for i in range(len(new_id)):
    #     # 1. 모든 대문자를 소문자로 치환한다.
    #     l = new_id[i].lower()
    #     # 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
    #     if not l.isalnum() and l not in check:
    #         continue
        # 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        # -> 점이라면 다음 문자가 점이 아니라면 추가
        # if new_id[i] == ".":
        #     if i < len(new_id)-1:
        #         if new_id[i+1] == ".":
        #             continue
        # 1단계: 대문자를 소문자로 치환
        
    new_id = new_id.lower()
    
    # 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
    allowed_characters = "-_."
    new_id = ''.join([ch for ch in new_id if ch.isalnum() or ch in allowed_characters])
    
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
    # answer.append(l)
    
    # changed = ''.join(answer)
    # print(changed)
    
    
    
    # 4. 마침표가 처음이나 끝에 위치한다면 제거합니다.
    new_id = new_id.strip('.')
    
    print(new_id)
    # if changed[0] == '.':
    #     changed = changed[1:]
    # if lenchanged[len(changed)-1] == '.':
    #     changed = changed[:len(changed)-2]
        
    # 5. 빈 문자열이라면, "a"대입
    if not new_id:
        new_id += "a"
    
    # 6. 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    if len(new_id) > 15:
        new_id = new_id[0:15]
    
    if new_id[-1] == ".":
        new_id = new_id.rstrip('.')
    
    # 7. 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해 붙인다.
    while len(new_id) < 3:
        new_id += new_id[-1]
        
    return new_id