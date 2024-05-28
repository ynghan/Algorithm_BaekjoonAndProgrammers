def solution(brown, yellow):
    
#     brown 
#     = x*y - (x-2)*(y-2)
#     = xy - (xy - 2(x+y) +4)
#     = 2(x+y) - 4
    
#     yellow 
#     = (x-2)*(y-2)
#     = xy - 2(x+y) + 4
    
#     brown + yellow = xy
    # 12 = 3*4 or 2*6 or 1*12
    answer = []
    xy = brown + yellow
    x = []
    y = []
    for i in range(1, xy+1):
        if xy % i == 0:
            if i >= xy // i :
                x.append(i)
                y.append(xy // i)
    
    for x_, y_ in zip(x,y):
        if brown == 2*(x_+y_) - 4:
            answer.append(x_)
            answer.append(y_)

    
    return answer