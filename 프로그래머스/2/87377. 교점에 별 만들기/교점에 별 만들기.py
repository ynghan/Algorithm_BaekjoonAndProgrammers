from itertools import combinations

def x_ans(l1, l2):
    if l1[0]*l2[1] - l1[1]*l2[0]: # 분모가 0이 아닌 경우
        return (l1[1]*l2[2] - l1[2]*l2[1]) / (l1[0]*l2[1] - l1[1]*l2[0])
    else: # 부모가 0인 경우
        return None

def y_ans(l1, l2):
    if l1[0]*l2[1] - l1[1]*l2[0]:
        return (l1[2]*l2[0] - l1[0]*l2[2]) / (l1[0]*l2[1] - l1[1]*l2[0])
    else:
        return None
    
def solution(line):
    answer = set()
    
    # line의 모든 직선들의 교점의 수 : len(line)을 순서와 상관없이 2개 고르는 방법 개수(조합)
    # 조합 수 만큼 반복문 돌리기 : len(line) * {len(line)-1} / 2
    combi = list(combinations(line,2))
    
    # print("combi : " , combi)
    
    for li1, li2 in combi:
        
        x = x_ans(li1, li2)
        y = y_ans(li1, li2)
        
        if x != None and y != None:
            if x % 1 == 0 and y % 1 == 0:
                answer.add((int(x),int(y)))
    
    x_max = max(meet[0] for meet in answer)
    x_min = min(meet[0] for meet in answer)
    y_max = max(meet[1] for meet in answer)
    y_min = min(meet[1] for meet in answer)
    
    # print("answer : " answer)
    # print(x_max, x_min, y_max, y_min)
    arr = []
    for i in range(y_max, y_min-1,-1):
        tmp = []
        for j in range(x_min,x_max+1):
            if (j,i) in answer:
                tmp.append("*")
            else:
                tmp.append(".")
        arr.append(''.join(tmp))
    
    return arr