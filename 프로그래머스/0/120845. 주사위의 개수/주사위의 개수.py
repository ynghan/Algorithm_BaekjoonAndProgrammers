def solution(box, n):
    answer = 1
    result = [box[i]//n for i in range(3)]
    # 리스트에 있는 모든 요소들의 곱을 반환하는 함수
    for i in result:
        answer *= i
        
    return answer