import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int k = array[1];

        String[] str = reader.readLine().split(" ");
        int[] score = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int[] arr = IntStream.of(score).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(arr[k-1]);
    }
}