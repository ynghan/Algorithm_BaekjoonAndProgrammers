from typing import Optional


class ListNode:
    def __init__(self, val=None, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class Solution:
    def keyLogger(self):
        N = int(input())

        result = []

        for _ in range(N):
            head = ListNode()
            dummy = head
            password = list(str(input().strip()))

            for char in password:
                if char == "<":
                    if dummy.prev:
                        dummy = dummy.prev

                elif char == ">":
                    if dummy.next:
                        dummy = dummy.next

                elif char == "-":
                    if dummy.prev:
                        dummy.prev.next = dummy.next
                        if dummy.next:
                            dummy.next.prev = dummy.prev
                        dummy = dummy.prev

                else:
                    new_node = ListNode(char)
                    if dummy.next:
                        new_node.next = dummy.next
                        dummy.next.prev = new_node
                    new_node.prev = dummy
                    dummy.next = new_node
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
