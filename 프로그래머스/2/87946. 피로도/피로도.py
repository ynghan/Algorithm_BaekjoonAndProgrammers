from itertools import permutations

def solution(k, dungeons):
    # 1. 던전 리스트를 최소 필요 피로도를 기준으로 내림차순 정렬
    dungeons.sort(key=lambda x: x[0], reverse=True)
    
    # 2. 현재 피로도 k보다 큰 최소 필요 피로도를 가진 던전 제거
    dungeons = [d for d in dungeons if d[0] <= k]
    
    # 결과를 저장할 변수
    max_count = 0
    
    # 3. 던전의 모든 순열에 대해 반복
    for perm in permutations(dungeons, len(dungeons)):
        # 현재 피로도
        current_k = k
        # 탐험한 던전 수
        count = 0
        
        # 던전 하나씩 탐험
        for dungeon in perm:
            # 현재 피로도로 탐험 가능한 경우
            if dungeon[0] <= current_k:
                current_k -= dungeon[1]  # 소모 피로도 만큼 감소
                count += 1  # 탐험한 던전 수 증가
            else:
                break  # 더 이상 탐험할 수 없으면 반복 중단
        
        # 4. 탐험한 던전 수 갱신
        max_count = max(max_count, count)
    
    # 5. 탐험할 수 있는 최대 던전 수 리턴
    return max_count
