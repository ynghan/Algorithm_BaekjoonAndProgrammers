import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(reader.readLine());
        for(int i = 0; i < cnt; i++) {
            int price = Integer.parseInt(reader.readLine());
            while (price > 0) {
                if (price / 25 > 0) {
                    System.out.print((price / 25) + " ");
                    price = price % 25;
                } else {
                    System.out.print("0 ");
                }
                if (price / 10 > 0) {
                    System.out.print((price / 10) + " ");
                    price = price % 10;
                } else {
                    System.out.print("0 ");
                }

                if (price / 5 > 0) {
                    System.out.print((price / 5) + " ");
                    price = price % 5;
                } else {
                    System.out.print("0 ");
                }
                if (price > 0) {
                    System.out.print(price);
                    price = 0;
                } else {
                    System.out.print("0");
                }

            }
            System.out.println();
        }
    }
}