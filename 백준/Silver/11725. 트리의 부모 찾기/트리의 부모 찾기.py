import collections
import sys

class Node:
    def __init__(self, val=0, parent=None):
        self.val = val
        self.parent = parent
        self.children = []


class Solution:
    def findParentOfTree(self):
        input = sys.stdin.readline
        N = int(input())

        # 그래프 만들기
        graph = collections.defaultdict(list)
        for i in range(N-1):
            a, b = map(int, input().rstrip().split())
            graph[a].append(b)
            graph[b].append(a)

        # 전체 노드를 생성해서 딕셔너리에 저장(키 : 노드의 val, 값: 노드 객체)
        node_dict = {i: Node(val=i) for i in range(1, N + 1)}

        # 트리 생성
        stack = [(1, None)]  # (노드 값, 부모 노드 값)
        while stack:
            node_val, parent_val = stack.pop()
            node = node_dict[node_val]
            node.parent = node_dict[parent_val] if parent_val else None
            for child_val in graph[node_val]:
                if child_val == parent_val:
                    continue
                child_node = node_dict[child_val]
                child_node.parent = node
                node.children.append(child_node)
                stack.append((child_val, node_val))

        # 노드 값의 오름차순으로 부모 값을 출력
        for i in range(2, N + 1):  # 루트 노드를 제외한 노드부터 시작
            print(node_dict[i].parent.val)

a = Solution()
a.findParentOfTree()