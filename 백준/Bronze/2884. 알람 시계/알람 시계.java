import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] time = reader.readLine().split(" ");

        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int m = 0;

        if (minute < 45) {
            int diff = 45 - minute;
            m = 60 - diff;
            if (hour == 0) {
                hour = 23;
            } else {
                hour -= 1;
            }
        } else {
            m = minute - 45;
        }
        
        System.out.print(hour + " " + m);
    }
}