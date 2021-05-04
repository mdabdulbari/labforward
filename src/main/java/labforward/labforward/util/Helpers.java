package labforward.labforward.util;

import java.util.Arrays;

public class Helpers {
    public static int countOccurrence(String word, String text) {
        String wordInString[] = text.split(" ");
        int wordOccurredTimes = 0;
        for (int i = 0; i < wordInString.length; i++) {
            if (word.equals(wordInString[i])) {
                wordOccurredTimes++;
            }
        }
        return wordOccurredTimes;
    }


    public static int getLevenshteinDistance(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }

        if (y.isEmpty()) {
            return x.length();
        }

        int substitution = getLevenshteinDistance(x.substring(1), y.substring(1))
                + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = getLevenshteinDistance(x, y.substring(1)) + 1;
        int deletion = getLevenshteinDistance(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }

}
