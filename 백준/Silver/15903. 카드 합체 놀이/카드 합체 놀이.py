class Solution:
    def cardJoinPlay(self):
        N, M = map(int, input().split())

        cardList = list(map(int, input().split()))

        for i in range(M):
            cardList.sort()
            cardList[0] += cardList[1]
            cardList[1] = cardList[0]

        total = 0
        for d in cardList:
            total += d

        print(total)



a = Solution()
a.cardJoinPlay()