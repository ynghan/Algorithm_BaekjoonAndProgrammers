import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int Num = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        double sum = 0;
        double Max = 0;
        double[] score = new double[Num];

        for(int i = 0; i < Num; i++) {
            score[i] = Double.valueOf(st.nextToken());
            if(score[i] > Max) {
                Max = score[i];
            }
        }

        for(int i = 0; i < Num; i++) {
            sum += score[i] / Max * 100;
        }

        System.out.println(sum / Num);

    }
}
