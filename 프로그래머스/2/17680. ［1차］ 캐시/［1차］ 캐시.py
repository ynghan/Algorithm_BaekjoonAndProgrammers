from collections import deque


def solution(cacheSize, cities):
    total_time = 0
    cache = deque()

    new_cities = []

    for i in cities:
        new_cities.append(i.upper())

    if cacheSize >= 1:
        idx = 0
        while idx < len(new_cities):
            if new_cities[idx] not in cache:
                if len(cache) == cacheSize:
                    cache.popleft()
                    cache.append(new_cities[idx])
                else:
                    cache.append(new_cities[idx])
                total_time += 5
            else:
                if len(cache) == cacheSize:
                    cache.remove(new_cities[idx])
                    cache.append(new_cities[idx])
                else:
                    cache.append(new_cities[idx])
                total_time += 1
            idx += 1
    else:
        total_time = len(cities) * 5        
    return total_time