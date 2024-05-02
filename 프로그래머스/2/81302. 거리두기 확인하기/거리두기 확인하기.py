def check_border(place, i, j):
    border = [(-1,-1), (-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(2,0),(0,2),(-2,0),(0,-2)]
    for dx, dy in border:
        # 허용되는 좌표 안에서
        if 0 <= i+dx < 5 and 0 <= j+dy < 5:
            # 주변 좌표에 "P"가 있다면
            if place[i+dx][j+dy] == "P":
                if abs(dx) == 2 or abs(dy) == 2:
                    if place[i+dx//2][j] == "X":
                        continue
                    elif place[i][j+dy//2] == "X":
                        continue
                    else:
                        return 0
                # 원래 좌표(i,j)에서 해당 P좌표로 이동한 크기(dx, dy)에서 
                # (0, dy)만큼 이동한 좌표와 (dx, 0)만큼 이동한 좌표가 둘 다 파티션인지 확인
                elif place[i][j+dy] != "X" or place[i+dx][j] != "X":
                    return 0
                else:
                    continue
            else:
                continue
                    
        else:
             continue
                
    return 1



def solution(places):
    answer = []

    for place in places:
        place_result = 1
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    if check_border(place, i, j) == 0:
                        place_result = 0
                        break 
            if place_result == 0:
                break
        answer.append(place_result)
        
    return answer
