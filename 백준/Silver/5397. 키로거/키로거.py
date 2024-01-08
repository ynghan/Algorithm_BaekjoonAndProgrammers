from typing import Optional


class ListNode:
    def __init__(self, val=None, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class Solution:
    def keyLogger(self):
        N = int(input())

        # N개의 문자열 저장할 리스트
        result = []

        # N번 반복
        for _ in range(N):
            # head, dummy 노드 생성
            head = ListNode()
            dummy = head
            # 비밀번호 입력
            password = list(str(input().strip()))

            # 비밀번호 -> 각 문자 요소 리스트
            for char in password:
                if char == "<":
                    # 현재 노드의 이전 노드로 이동
                    if dummy.prev:
                        dummy = dummy.prev

                elif char == ">":
                    # 현재 노드의 다음 노드로 이동
                    if dummy.next:
                        dummy = dummy.next

                elif char == "-":
                    # 이전 노드가 있는 경우
                    if dummy.prev:
                        # 현재 노드의 이전 노드의 다음 노드를 현재 노드의 다음 노드에 연결
                        dummy.prev.next = dummy.next
                        # 다음 노드가 있는 경우
                        if dummy.next:
                            # 현재 노드의 다음 노드의 이전 노드를 현재 노드의 이전 노드에 연결
                            dummy.next.prev = dummy.prev
                        # 현재 노드를 현재 노드의 이전 노드에 연결
                        dummy = dummy.prev
                
                else:
                    # 문자 값을 가진 새로운 노드 생성
                    new_node = ListNode(char)
                    # 다음 노드가 있는 경우
                    if dummy.next:
                        new_node.next = dummy.next
                        dummy.next.prev = new_node
                    # 새로운 노드의 이전 노드를 현재 노드에 연결
                    new_node.prev = dummy
                    # 현재 노드의 다음 노드를 새로운 노드에 연결
                    dummy.next = new_node
                    # 현재 노드에 새로운 노드 연결
                    dummy = new_node
            result.append(self.toString(head.next))

        for string in result:
            print(string)

    # 노드를 순회하여 문자열 생성
    def toString(self, head: Optional[ListNode]) -> str:
        current = head
        string = ""
        while current:
            string += current.val
            current = current.next
        return string


a = Solution()
a.keyLogger()



# def connect(s, e):

#connect(pprev, cursor)