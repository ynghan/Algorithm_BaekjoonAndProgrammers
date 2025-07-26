import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        String[] strArr1 = toStrArr(str1.toLowerCase());
        String[] strArr2 = toStrArr(str2.toLowerCase());

        Map<String, Integer> map1 = getCountMap(strArr1);
        Map<String, Integer> map2 = getCountMap(strArr2);

        int intersection = 0;
        int union = 0;

        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        if (union == 0) return 65536;
        return (int) (((double) intersection / union) * 65536);
    }

    public Map<String, Integer> getCountMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }

    public String[] toStrArr(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                list.add("" + c1 + c2);
            }
        }
        return list.toArray(new String[0]);
    }
}
