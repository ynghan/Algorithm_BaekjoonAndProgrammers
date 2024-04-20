# rank
# attendance : boolean 배열
def solution(rank, attendance):
    dic = {}
    l = []
    
    for num, rnk in enumerate(rank):
        dic[rnk] = num
    sorted_list = sorted(dic.items())
    
    for key,value in sorted_list:
        if attendance[value]:
            l.append(value)
    
    return l[0]*10000+l[1]*100+l[2]

# [3,7,2,5,4,6,1]에서 true만 담는다.
# dict = {등수:번호}
# 등수 [7,2,5,4] -> [2,4,5,7]
# 번호 [1,2,3,4] -> [2,4,3,1][:3]
# 2*10000 + 4*100 + 3*1