from collections import deque


def test_problem_queue(num):
    deq = deque([i for i in range(1, num + 1)])
    while len(deq) > 1:
        deq.popleft()
        deq.append(deq.popleft())
    return deq.popleft()

N = int(input())
result = test_problem_queue(N)
print(result)