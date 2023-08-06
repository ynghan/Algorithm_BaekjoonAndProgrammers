
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sensorNum = Integer.parseInt(br.readLine());

        int stationNum = Integer.parseInt(br.readLine());

        int[] sens_location = new int[sensorNum];

        Integer[] sens_diff = new Integer[sensorNum-1];

        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < sensorNum; i++) {
            sens_location[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sens_location);

        for(int i = 0; i < sensorNum - 1 ; i++) {
            sens_diff[i] = sens_location[i+1] - sens_location[i];
        }

        Arrays.sort(sens_diff, Collections.reverseOrder());

        for(int i = stationNum -1 ; i < sensorNum-1;i++) {
            sum += sens_diff[i];
        }
        System.out.println(sum);
    }
}
