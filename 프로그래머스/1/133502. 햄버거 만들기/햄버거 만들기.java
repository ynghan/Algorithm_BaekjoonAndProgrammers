import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ing : ingredient) {
            stack.addLast(ing);

            // 스택에 최소 4개 이상 쌓여야 햄버거 완성 가능
            if (stack.size() >= 4) {
                // 뒤에서 4개 확인 (1-2-3-1)
                if (stack.peekLast() == 1) {
                    int a = stack.removeLast();
                    int b = stack.removeLast();
                    int c = stack.removeLast();
                    int d = stack.removeLast();

                    if (d == 1 && c == 2 && b == 3 && a == 1) {
                        answer++; // 햄버거 완성
                    } else {
                        // 햄버거 패턴이 아니면 다시 넣어줘야 함
                        stack.addLast(d);
                        stack.addLast(c);
                        stack.addLast(b);
                        stack.addLast(a);
                    }
                }
            }
        }
        return answer;
    }
}