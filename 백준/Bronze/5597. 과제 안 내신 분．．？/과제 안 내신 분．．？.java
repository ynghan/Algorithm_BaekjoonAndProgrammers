import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[28];


        for(int i = 0; i < 28; i++) {
            int num = Integer.parseInt(reader.readLine());
            arr[i] = num;
        }

        int[] array = Arrays.stream(arr).sorted().toArray();

        if (array[0] == 2) {
            System.out.println("1");
        } else if (array[0] == 3) {
            System.out.println("1");
            System.out.println("2");
        } 

        for(int i = 0; i < 28; i++) {
            if(i < 27) {
                if (array[i+1] - array[i] != 1) {
                    System.out.println(array[i]+1);
                }
            }
        }
        
        if(array[27] == 28) {
            System.out.println("29");
            System.out.println("30");
        } else if (array[27] == 29) {
            System.out.println("30");
        }
    }
}