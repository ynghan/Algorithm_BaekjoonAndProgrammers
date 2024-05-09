def solution(s):
    # 1. 집합 s에서 원소의 길이만큼 오름차순 정렬
    answer = []
    result = []
    a = s[2:len(s)-2]
    
    k = a.split("},{")
    
    for i in k:
        m = i.split(",")
        w = []
        for q in m:
            w.append(int(q))
        answer.append(w)
    answer.sort(key=len)
    
    # 2. 첫 번째 원소 append
    # 3. 두 번째 원소에서 없는 요소 append : for
    # 4. 세 번째 요소 for 
    # 5. 네 번째 요소 for 
    s = set()
    for idx in range(len(answer)):
        if idx == 0:
            result.append(answer[idx][0])
            s.add(answer[idx][0])  
        else:
            for i in answer[idx]:
                if i not in s:
                    s.add(i)
                    result.append(i)
    return result
    
    
    
    
    # 문자를 집합으로 어떻게 바꾸지?
    # 길이를 기준으로 오름차순 정렬하는 법