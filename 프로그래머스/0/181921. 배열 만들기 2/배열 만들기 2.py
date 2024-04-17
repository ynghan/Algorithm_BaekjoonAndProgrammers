def solution(l, r):
    answer = []
    # l 이상 r 이하의 정수 
    # 숫자 "0"과 "5"로만 이루어진 모든 정수
    # 오름차순
    for i in range(l, r+1):
        set1 = set(str(i))
        set2 = {'0','5'}
        if set(set1).issubset(set2):
            print(i)
            answer.append(i)
    if not answer:
        answer.append(-1)
        
        
    # l 부터 r 까지 반복문 수행
    # 각 숫자를 문자열로 변환후 set으로 변환
    # set으로 변환했을 때, 0과 5만 남았는지 확인
    # 확인한 숫자는 배열에 append
    # 배열 오름차순 정렬하기
    
    return answer