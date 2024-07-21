import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = reader.readLine();
        int length = string.length();
        int num = Integer.parseInt(string);
        int[] intArr = new int[length];
        for(int i = length-1; i >= 0; i--) {
            int k = (int) (num / Math.pow(10, i));
            num = (int) (num % Math.pow(10, i));
            intArr[i] = k;
        }

        Integer[] array = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());

        for (int i : array) {
            System.out.print(i);
        }
    }
}