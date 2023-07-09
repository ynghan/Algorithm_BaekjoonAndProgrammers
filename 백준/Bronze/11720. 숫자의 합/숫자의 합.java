import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sNum = Integer.parseInt(st.nextToken());

        String s = bf.readLine();

        char[] cNum = new char[s.length()];

        int sum = 0;

        for(int i = 0; i < sNum; i++) {
            cNum[i] = s.charAt(i);
            sum += ((int) cNum[i] - '0');
        }
        System.out.println(sum);
    }
}
