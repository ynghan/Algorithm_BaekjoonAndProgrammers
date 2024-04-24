def solution(spell, dic):
    answer = 0
    spell.sort()
    print(spell)
    for word in dic:
        if spell == sorted(list(word)):
            return 1
    return 2