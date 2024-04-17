# 4개의 값을 오름차순 정렬한다.
# 3번의 반복문을 돌린다.
# 첫 번째 요소를 기준으로 두 번째 요소와 비교한다.
# 같으면 count 1 증가, 다르면 dupl 리스트에 count를 append하고, 기준을 두 번째 요소로 변경



def solution(a, b, c, d):
    answer = 1
    num = [a,b,c,d]
    num.sort()
    key = []
    value = []
    idx = 0
    count = 1

    # print(num) # [1, 1, 2, 4]

    while idx+count < 4: # 비교하는 횟수는 3번
        if num[idx] == num[idx+count]:
            count += 1
        else:
            key.append(num[idx])
            value.append(count)
            idx = idx + count
            count = 1

    key.append(num[idx])
    value.append(count)

    if len(key) == 4:
        answer = min(a,b,c,d)

    elif len(key) == 3:
        for i in range(len(value)):
            if value[i] != 2:
                answer *= key[i]

    elif len(key) == 1:
        answer = 1111 * key[0]

    elif len(key) == 2:
        if value[0] == value[1]:
            answer = (key[0]+key[1]) * abs(key[0] - key[1])
        else:
            p = 0
            q = 0
            for i in range(len(value)):
                if value[i] == 3:
                    p = key[i]
                else:
                    q = key[i]
            answer = (10 * p + q)**2


    return answer