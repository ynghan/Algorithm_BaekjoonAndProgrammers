from sys import stdin

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, edges):
    parent = [0] * (n + 1)
    for i in range(1, n + 1):
        parent[i] = i

    edges.sort(key=lambda x: x[2])

    total_weight = 0
    max_weight = 0

    for a, b, weight in edges:
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            total_weight += weight
            max_weight = max(max_weight, weight)

    return total_weight - max_weight

n, m = map(int, stdin.readline().split())
edges = [tuple(map(int, stdin.readline().split())) for _ in range(m)]
print(solution(n, edges))
