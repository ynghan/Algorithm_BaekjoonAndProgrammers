import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[15][15];

        for(int i = 0; i < 5; i++) {
            char[] charArray = reader.readLine().toCharArray();
            for(int j = 0; j < 15; j++) {
                if(j < charArray.length) {
                    board[i][j] = charArray[j];
                } else {
                    board[i][j] = ' ';
                }
            }
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[j][i] == ' ') {
                    System.out.print("");
                } else {
                    System.out.print(board[j][i]);
                }
            }
        }
    }
}