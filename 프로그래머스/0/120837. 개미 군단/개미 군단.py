def solution(hp):
    jangun = hp // 5
    beungjeong = (hp % 5) // 3
    il = ((hp % 5) % 3)
    return jangun + beungjeong + il