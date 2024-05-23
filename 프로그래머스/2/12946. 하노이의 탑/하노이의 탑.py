# 2
# 출발 -> 도착 : [출발, 경유] [출발, 도착] [경유, 도착]

# 3
# 출발 -> 도착 : [출발, 도착] [출발, 경유] [도착, 경유] [출발, 도착] [경유, 출발] [경유, 도착] [출발, 도착]
def hanoii(n, start, end):
    
    middle = 6 - start - end
    
    if n == 1:
        return [[start, end]]
    elif n == 2:
        return [[start, middle], [start, end], [middle, end]]
    else:
        return hanoii(n-1,start, middle) + hanoii(1, start, end) + hanoii(n-1,middle, end)
    
    
    # if n == 1:
    #     if k == 3:
    #         return [[1,3]]
    #     elif k == 2:
    #         return [[1,2]]
    #     else:
    #         return [[1,1]]
    # elif n == 2:
    #     if k == 3:
    #         return [[1,2], [1,3], [2,3]]
    #     elif k == 2:
    #         return [[1,3], [1,2], [3,2]]
    # else:
    #     if k == 3:
    #         return hanoii(n-1,2) + hanoii(1,3) + hanoii(n-1,3)
    #     elif k == 2:
    #         return hanoii(n-1,3) + hanoii(1,2) + hanoii(n-1,2)
        
        # return hanoii(2,2) + hanoii(1,3) + hanoii(2,3)
        # [1,3], [1,2], [3,2] + [1,3] + [1,2], [1,3], [2,3]

            

# 1 -> 3 : [1,2] [1,3] [2,3]
# 1 -> 2 : [1,3] [1,2] [3,2]
# 2 -> 3 : [2,1] [2,3] [1,3]



def solution(n):
    answer = hanoii(n, 1, 3)
    return answer