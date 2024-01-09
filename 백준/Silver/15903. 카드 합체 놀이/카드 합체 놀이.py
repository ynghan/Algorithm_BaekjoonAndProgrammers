class Solution:
    def cardJoinPlay(self):
        N, M = map(int, input().split())

        cardList = list(map(int, input().split()))

        for i in range(M):
            cardList.sort()
            cardList[0] += cardList[1]
            cardList[1] = cardList[0]

        print(sum(cardList))



a = Solution()
a.cardJoinPlay()