import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String originalWord = reader.readLine();

        List<String> wordStates = new ArrayList<>();
        wordStates.add(originalWord);

        String currentWord = originalWord;
        int cycleLength = 0;

        while (true) {
            currentWord = blinkEye(currentWord);
            cycleLength++;

            if (currentWord.equals(originalWord)) {
                break;
            }
            wordStates.add(currentWord);
        }

        int finalStateIndex = N % cycleLength;
        System.out.println(wordStates.get(finalStateIndex));
    }

    private static String blinkEye(String word) {
        StringBuilder even = new StringBuilder(word.length() / 2 + 1);
        StringBuilder odd = new StringBuilder(word.length() / 2);

        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0) {
                even.append(word.charAt(i));
            } else {
                odd.insert(0, word.charAt(i));
            }
        }

        return even.append(odd).toString();
    }
}