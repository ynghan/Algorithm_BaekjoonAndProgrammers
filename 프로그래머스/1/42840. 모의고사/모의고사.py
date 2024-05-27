def solution(answers):
    count = 0
    
    one = 0
    two = 0
    three = 0
    
    one_num = [1,2,3,4,5]
    two_num = [2,1,2,3,2,4,2,5]
    three_num = [3,3,1,1,2,2,4,4,5,5]
    
    while count < len(answers):
        
        if answers[count] == one_num[count%len(one_num)]:
            one += 1
        if answers[count] == two_num[count%len(two_num)]:
            two += 1
        if answers[count] == three_num[count%len(three_num)]:
            three += 1
        
        count += 1
        
    num = [one, two, three]
        
    answer = []
    for idx, val in enumerate(num):
        if val == max(num):
            answer.append(idx+1)
        

    return answer