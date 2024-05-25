# 특정 프로세스가 몇 번째로 실행되는지 구하기

# 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
# 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
# 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
# 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료합니다.

# [2, 1, 3, 2] -> [1, 3, 2, 2] -> [3, 2, 2] -> [2, 2, 3] -> [2, 3] -> [3]
# [2, 1, 3, 2] -> [1, 3, 2, 2] -> [3, 2, 2, 1] -> [2,2,1] -> [2,1] -> [1] : C D A B
# -> 큰 숫자가 우선 순위가 높다.

# ex
# priorities [2,1,3,2] 이고 location은 C인 경우 answer은 1

def solution(priorities, location):

    rank = 1
    current_idx = location

    while True:
        num = priorities.pop(0)
        if priorities:
            if num < max(priorities):
                priorities.append(num)
                if current_idx == 0:
                    current_idx = len(priorities)-1
                else:
                    current_idx -= 1
            else:
                if current_idx == 0:
                    return rank
                else:
                    rank += 1
                    current_idx -= 1
        else:
            return rank