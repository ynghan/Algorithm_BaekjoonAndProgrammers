import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> x = new Stack<>();
        Stack<Integer> y = new Stack<>();
        for(int i = 0; i < 3; i++) {
            String[] s = reader.readLine().split(" ");
            int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            if (x.contains(array[0])) {
                int idx = x.indexOf(array[0]);
                x.remove(idx);
            } else {
                x.push(array[0]);
            }
            if (y.contains(array[1])) {
                int idx = y.indexOf(array[1]);
                y.remove(idx);
            } else {
                y.push(array[1]);
            }
        }

        System.out.print(x.pop() + " " + y.pop());
    }
}