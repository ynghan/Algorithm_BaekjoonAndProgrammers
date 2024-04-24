def solution(spell, dic):
    answer = 0
    spell.sort()
    print(spell)
    for word in dic:
        a = list(word)
        a.sort()
        if spell == a:
            return 1
    return 2