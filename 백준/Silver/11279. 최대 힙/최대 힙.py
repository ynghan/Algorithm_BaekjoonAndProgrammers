import sys
import heapq

class Solution:

    def maxHeap(self) -> None:
        input = sys.stdin.readline
        heap = []
        N = int(input())
        for _ in range(N):
            x = int(input())
            if x == 0:
                if heap:
                    print(heapq.heappop(heap)[1])
                else:
                    print(0)
            else:
                heapq.heappush(heap, (-x, x))


a = Solution()
a.maxHeap()

