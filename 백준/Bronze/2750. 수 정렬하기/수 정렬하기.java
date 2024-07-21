import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int cnt = Integer.parseInt(reader.readLine());

        for(int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(reader.readLine());
            list.add(num);
        }

        list.sort(null);

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}