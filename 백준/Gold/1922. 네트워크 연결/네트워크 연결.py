import heapq
import sys

class Solution:
    def minSpanningTree(self):

        input = sys.stdin.readline

        N = int(input())
        M = int(input())

        edges = [tuple(map(int, input().split())) for _ in range(M)]

        # 0번째 인덱스는 사용하지 않음
        graph = [[] for _ in range(N+1)]

        # (무방향) 그래프 생성
        for idx, adj, cost in edges:
            graph[idx].append((cost, adj))
            graph[adj].append((cost, idx))

        # 임의의 정점을 시작으로 선택한다.
        visited = [False] * (N + 1)
        visited[1] = True
        heap = []
        # 가중치 기준으로 오름차순 정렬
        for cost, adj in graph[1]:
            heapq.heappush(heap, (cost, adj))

        # 트리의 누적 가중치
        result = 0
        # 포함한 간선의 개수
        used_edges = 0

        # 포함시킨 간선의 개수가 n - 1 미만일 경우 반복
        while used_edges < N - 1:
            # 가중치가 가장 낮은 간선 선택
            cost, idx = heapq.heappop(heap)
            # 이미 방문한 정점이라면
            if visited[idx]:
                continue
            visited[idx] = True
            result += cost
            used_edges += 1
            # 선택한 정점과 연결된 간선들을 우선순위 큐에 넣는다.
            for adj_cost, adj in graph[idx]:
                if not visited[adj]:
                    heapq.heappush(heap, (adj_cost, adj))

        return result

A = Solution()
print(A.minSpanningTree())