def solution(number, k):
    answer = []  # 결과를 저장할 리스트
    
    for num in number:
        # answer가 비어있지 않고, k가 0보다 크며, answer의 마지막 원소가 현재 숫자보다 작은 동안 반복
        while answer and k > 0 and answer[-1] < num:
            answer.pop()  # answer의 마지막 원소 제거
            k -= 1  # 제거할 수 있는 횟수 감소
        answer.append(num)  # 현재 숫자를 결과에 추가
    
    # 제거할 수 있는 횟수가 남아있다면, 뒤에서부터 해당 횟수만큼 제거
    if k > 0:
        answer = answer[:-k]
    
    return ''.join(answer)  # 리스트를 문자열로 변환하여 반환