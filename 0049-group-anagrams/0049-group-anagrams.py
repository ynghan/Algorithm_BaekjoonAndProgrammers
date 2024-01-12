class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        anagram = {}

        for string in strs:
            sort = tuple(sorted(string))

            if sort in anagram:
                anagram[sort].append(string)
            else:
                anagram[sort] = [string]

        return list(anagram.values())
