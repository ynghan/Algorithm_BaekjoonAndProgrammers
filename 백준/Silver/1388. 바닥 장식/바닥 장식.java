import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int row;
        int column;

        int num = 0;

        String input;
        char[][] chars;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());

        chars = new char[row][column];


        for(int i = 0 ; i < row; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0 ; j < column; j++) {
                chars[i][j] = split[j].charAt(0);
            }
        }

        for(int i = 0 ; i < row; i++) {
            for (int j = 0 ; j < column; j++) {

                switch (chars[i][j]) {
                    case '-':
                        if ( i == 0 && j == 0)
                        {
                            num++;
                            break;
                        }
                        else if ( i == 0 && j > 0) {
                            if(chars[i][j-1] == chars[i][j]) {
                                break;
                            }
                            num++;
                            break;
                        }
                        else if (i > 0 && j == 0) {
                            num++;
                            break;
                        }
                        else if(i > 0 && j > 0) {
                            if(chars[i][j-1] == chars[i][j]) {
                                break;
                            }
                            num++;
                            break;
                        }

                    case '|':
                        if ( i == 0 && j == 0)
                        {
                            num++;
                            break;
                        }
                        else if ( i > 0 && j == 0) {
                            if(chars[i-1][j] == chars[i][j]) {
                                break;
                            }
                            num++;
                            break;
                        }
                        else if (i == 0 && j > 0) {
                            num++;
                            break;
                        }
                        else if(i > 0 && j > 0) {
                            if(chars[i-1][j] == chars[i][j]) {
                                break;
                            }
                            num++;
                            break;
                        }
                }
            }
        }

        System.out.println(num);

    }
}