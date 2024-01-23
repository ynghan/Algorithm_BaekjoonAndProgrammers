class Solution:
    def library(self):
        N, M = map(int, input().split())
        books = list(map(int, input().split()))
        left_books = sorted([book for book in books if book < 0], key=abs, reverse=True)
        right_books = sorted([book for book in books if book > 0], key=abs, reverse=True)

        res = 0
        for i in range(0, len(left_books), M):
            res += abs(left_books[i]) * 2

        for i in range(0, len(right_books), M):
            res += right_books[i] * 2

        if left_books and right_books:
            res -= max(abs(left_books[0]), right_books[0])
        elif left_books:
            res -= abs(left_books[0])
        elif right_books:
            res -= right_books[0]

        print(res)


Solution().library()
