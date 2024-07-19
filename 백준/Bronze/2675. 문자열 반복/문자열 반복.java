import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        String[] str = new String[num];

        for(int i = 0 ; i < num; i++) {
            String[] s = reader.readLine().split(" ");
            int cnt = Integer.parseInt(s[0]);
            char[] charArray = s[1].toCharArray();
            char[] extendArray = new char[cnt * s[1].length()];

            for(int j = 0; j < extendArray.length; j++) {
                extendArray[j] = charArray[j / cnt];
            }
            str[i] = String.copyValueOf(extendArray);
        }

        for(int i = 0; i < num; i++) {
            System.out.println(str[i]);
        }
    }
}