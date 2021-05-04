package labforward.labforward.Services;

import labforward.labforward.util.Helpers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotebookService {
    public int getFrequency(String word, String notebookEntry) {
        return Helpers.countOccurrence(word, notebookEntry);
    }

    public List<String> getSimilarWords(String word, String notebookEntryText) {
        String[] wordsInNotebook = notebookEntryText.split(" ");
        List<String> similarWords = new ArrayList<>();
        for (String currentWord : wordsInNotebook)
        {
            if (!currentWord.equals(word) & Helpers.getLevenshteinDistance(currentWord, word) == 1) {
                similarWords.add(currentWord);
            }
        }
        return similarWords;
    }
}
