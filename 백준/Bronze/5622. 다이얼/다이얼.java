import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] dialNumber = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M','N','O'}, {'P','Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};

        char[] charArray = reader.readLine().toCharArray();
        int sum = 0;
        for(int i = 0; i < charArray.length; i++) {
            for(int j = 0; j < dialNumber.length; j++) {
                for (char a : dialNumber[j]) {
                    if(a == charArray[i]) {
                        sum += j + 3;
                    }
                }
            }
        }
        System.out.println(sum);

    }
}