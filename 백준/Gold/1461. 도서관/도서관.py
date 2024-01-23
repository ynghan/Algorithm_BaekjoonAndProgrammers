class Solution:
    def library(self):
        N, M = map(int, input().split())
        books = list(map(int, input().split()))
        
        # 음수와 양수로 나누고, 절대값 기준으로 내림차순 정렬
        left_books = sorted([book for book in books if book < 0], key=abs, reverse=True)
        right_books = sorted([book for book in books if book > 0], key=abs, reverse=True)
        
        res = 0
        # 왼쪽(음수)에 있는 책들을 옮기는 거리 계산
        for i in range(0, len(left_books), M):
            res += abs(left_books[i]) * 2
        
        # 오른쪽(양수)에 있는 책들을 옮기는 거리 계산
        for i in range(0, len(right_books), M):
            res += right_books[i] * 2
        
        # 마지막 책을 가져올 때는 왕복하지 않으므로, 가장 먼 거리 하나를 빼줌
        if left_books and right_books:
            res -= max(abs(left_books[0]), right_books[0])
        elif left_books:
            res -= abs(left_books[0])
        elif right_books:
            res -= right_books[0]
        
        print(res)

# 코드 실행
Solution().library()
