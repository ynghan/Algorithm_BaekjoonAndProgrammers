# lines를 시작 좌표를 기준으로 오름차순 정렬한다.
# 1과 2 비교
# 2와 3 비교
# 3과 1 비교

# 1차원 = sum(2차원, []) [[1,2] + [3,4]] = [1,2,3,4]

def d(a, b):
    if a[1] > b[0]:
        if a[1] > b[1]:
            return [b[0],b[1]]
        else:
            return [b[0],a[1]]
    else:
         return []

def solution(lines):
    answer = 0
    max_num = 0
    min_num = 0
    lines.sort()
    li = sum(lines,[])
    max_num = max(li)
    min_num = min(li)
    
    newlist = [False for _ in range(abs(max_num - min_num))]
    
    a = d(lines[0], lines[1])
    if a:
        for i in range(a[0],a[1]):
            newlist[i] = True
        
    b = d(lines[1], lines[2])
    if b:
        for i in range(b[0],b[1]):
            newlist[i] = True
    
    c = d(lines[0], lines[2])
    if c:
        for i in range(c[0],c[1]):
            newlist[i] = True

    for i in newlist:
        if i :
            answer += 1
    return answer
    

# def solution(lines):
#     answer = 0
#     lines.sort()
#     a = d(lines[0], lines[1])
#     b = d(lines[1], lines[2])
#     c = d(lines[0], lines[2])
    
#     li = sum(lines, [])
#     if a > 0 and b > 0:
#         return li[-2] - li[1]
#     else:
#         a + b