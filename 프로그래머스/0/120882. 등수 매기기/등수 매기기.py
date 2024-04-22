def solution(score):
    li = []
    for i in score:
        li.append(sum(i))
    sorted_score = sorted(li, reverse=True)
    ranks = [sorted_score.index(s) + 1 for s in li ]
    return ranks