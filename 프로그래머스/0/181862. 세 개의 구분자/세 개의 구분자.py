def solution(myStr):
    str = myStr.replace("a", " ").replace("b"," ").replace("c"," ")
        
    list1 = str.split()
    
    if list1:
        return list1
    else:
        return ["EMPTY"]
    

    