# 3,6
# 6보다 큰 수 -> 7,8
# 6보다 작거나 같은 수 -> 4,5,6

# 최대값이 되는 수 : max(두 요소) =< x < sum(두 요소)
# 최대값 보다 작은 수 : x+min(두 요소) > max(두 요소)
def solution(sides):
    count = 0
    for i in range(1, sum(sides)):
        if max(sides) < i:
            if i < sum(sides):
                count += 1
        else:
            if i + min(sides) > max(sides):
                count += 1
    return count