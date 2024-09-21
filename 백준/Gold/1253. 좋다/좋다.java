import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        arr = new int[N];

        String[] s = reader.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // 오름차순 정렬을 해야한다.
        Arrays.sort(arr);

        /**
         * int 배열에 각 숫자를 입력받는다.
         * 각 숫자에 대해 투 포인터를 통해 더한 후 합이 각 숫자와 동일하면 count하고
         * 아니라면 다음 숫자로 넘어간다.
         */
        int count = 0;

        for(int i = 0; i < N; i++) {
            if(count_sum(i)) count++;
        }

        System.out.println(count);
    }

    public static boolean count_sum(int i) {

        /**
         * arr[i]가 다른 2개의 숫자 합과 일치하면 true 없다면 false 반환
         */
        int left = 0;
        int right = N - 1;

        while(left < right) {
            if(left == i) {
                left++;
                continue;
            }
            if(right == i) {
                right--;
                continue;
            }
            int ans = arr[i];
            int left_val = arr[left];
            int right_val = arr[right];

            /**
             * 언제 왼쪽을 이동시켜야 하고 언제 오른쪽을 이동시켜야 하는가?
             */
            if(ans == left_val + right_val) {
                return true;
            }
            else if(ans < left_val + right_val) {
                right--;
            }
            else {
                left++;
            }
        }

        return false;


    }
}

