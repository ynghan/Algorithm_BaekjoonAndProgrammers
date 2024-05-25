def solution(priorities, location):

    rank = 1 # 일단 이거는 몇 번째로 pop 됐는지 나타내는 변수입니다.
    current_idx = location # 이거는 현재 몇 번째 인덱스에 있는지 추적하는 인덱스 ㅋㅋ

    while True: # 무한 반복
        num = priorities.pop(0) # 하나를 pop 합니다.
        if priorities: # 만약 priorities가 있다면, 이거 안해주니까 [1], 0 이렇게 주어진 경우에 무한 루프 걸리더라고요?
            if num < max(priorities): # priorities의 최대값과 비교해줍니다.
                priorities.append(num) # 작으면 다시 넣어줍니다.
                if current_idx == 0: # 이때 location 값이 0이었다면 
                    current_idx = len(priorities)-1 # 다시 넣은 인덱스 값으로 변경해줍니다.
                else: # 0이 아니라면
                    current_idx -= 1 # 그냥 1 감소 시킵니다.
            else: # 탈출하는 경우?
                if current_idx == 0: # location이 0이었다면 해당 값이 몇 번째로 탈출했는지 말하라는 거니까 rank 반환해 줍니다.
                    return rank
                else: # 이거의 순위를 말하라는게 아니니 
                    rank += 1  # 순위 증가 시키고 다음 반복문 타도록 해줍니다.
                    current_idx -= 1 # 이거는 0이 아니니까 그냥 1 감소시키면 됩니다.
        else:
            return rank



