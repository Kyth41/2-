import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordChain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();

        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    words.add(st.nextToken());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        if (words.isEmpty()) {
            System.out.println("Файл пуст или не содержит слов.");
            return;
        }

        String result = getLine(words);
        
        if (result != null) {
            System.out.println("\nИтоговая цепочка слов:");
            System.out.println(result);
        } else {
            System.out.println("\nИз этих слов невозможно составить цепочку по заданному правилу.");
        }
        
        scanner.close();
    }


    public static String getLine(List<String> words) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            List<String> remainingWords = new ArrayList<>(words);
            String startWord = remainingWords.remove(i);

            resultBuilder.append(startWord);

            if (buildChain(startWord, remainingWords, resultBuilder)) {
                return resultBuilder.toString();
            }

            resultBuilder.setLength(0);
        }
        return null;
    }

    private static boolean buildChain(String lastWord, List<String> remainingWords, StringBuilder builder) {
        if (remainingWords.isEmpty()) {
            return true;
        }

        char lastChar = Character.toLowerCase(lastWord.charAt(lastWord.length() - 1));

        for (int i = 0; i < remainingWords.size(); i++) {
            String nextWord = remainingWords.get(i);
            char firstChar = Character.toLowerCase(nextWord.charAt(0));

            if (lastChar == firstChar) {
                int lengthBeforeAppend = builder.length();

                builder.append(" ").append(nextWord);
                
                String removedWord = remainingWords.remove(i);

                if (buildChain(nextWord, remainingWords, builder)) {
                    return true; 
                }

                remainingWords.add(i, removedWord);
                builder.setLength(lengthBeforeAppend); 
            }
        }
        return false;
    }
}