import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
            sum += num;
        }

        list.sort(null);
        System.out.println(sum/5);
        System.out.println(list.get(2));
    }
}