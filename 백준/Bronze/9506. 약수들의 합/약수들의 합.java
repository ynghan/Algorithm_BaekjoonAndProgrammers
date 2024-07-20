import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int num = Integer.parseInt(reader.readLine());
            Stack<Integer> stack =  new Stack<>();
            if ( num == -1) {
                break;
            }
            int cnt = 0;
            for(int i = 1; i < num; i++) {
                if(num % i == 0) {
                    stack.push(i);
                }
            }
            int sum = 0;
            for (Integer i : stack) {
                sum += i;
            }
            if (sum == num) {
                System.out.print(sum + " = " + stack.get(0));
                for(int i = 1; i < stack.size(); i++) {
                    System.out.print(" + " + stack.get(i));
                }
                System.out.println();
            } else {
                System.out.print(num + " ");
                System.out.println("is NOT perfect.");
            }
        }

    }
}