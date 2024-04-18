def solution(names):
    answer = []
    # 최대 5명씩 탑승가능한 놀이기구
    # names : 놀이기구를 타기 위한 사람들의 이름이 담긴 문자열 리스트
    # 앞에서 부터 5명씩 묶은 그룹의 가장 앞에 서있는 사람들의 이름을 담은 리스트
    return names[::5]