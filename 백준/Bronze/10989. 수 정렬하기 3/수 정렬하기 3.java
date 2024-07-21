import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(reader.readLine());
        int[] intArr = new int[cnt];
        
        for(int i = 0; i < cnt; i++) {
            intArr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(intArr);

        StringBuilder sb = new StringBuilder();
        for (int i : intArr) {
            sb.append(i).append('\n');
        }
        
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}