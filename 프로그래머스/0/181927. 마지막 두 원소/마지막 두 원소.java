import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
    int l = num_list.length;
    int[] answer = new int[l + 1];

    // ✅ 올바른 복사
    System.arraycopy(num_list, 0, answer, 0, l);

    int last = num_list[l - 1];
    int before = num_list[l - 2];

    if (before < last) {
        answer[l] = last - before;
    } else {
        answer[l] = last * 2;
    }

    return answer;
}
}