import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수가 주어지면, 그 수의 정수 제곱근을 구하는 프로그램
 *
 * 출력 : 첫째 줄에 q^2 >= n 인 가장 작은 음이 아닌 정수 q 출력
 */

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long N = Long.parseLong(br.readLine());
    long low = 1;
    long high = N;
    long ans = N;

    while (low <= high) {
      long mid = (low + high) / 2;
      if (mid == 0) {
        ans = 0;
        break;
      }
      long remain = N / mid;
      if(N % mid != 0) {
        remain++;
      }
      if (mid >= remain) {  // mid * mid > N
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    System.out.println(ans);
  }
}
