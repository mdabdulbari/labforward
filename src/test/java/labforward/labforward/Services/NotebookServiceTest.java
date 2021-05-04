package labforward.labforward.Services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotebookServiceTest {
    @Autowired
    private NotebookService notebookService;

    @Test
    @DisplayName("should return frequency as 0 if empty string is provided")
    public void testZeroFrequency() {
        int expectedFrequency  = 0;
        String wordToSearch = "";
        String notebookEntry = "120 on the needle";

        int result = notebookService.getFrequency(wordToSearch, notebookEntry);

        assertEquals(expectedFrequency, result);
    }

    @Test
    @DisplayName("should return frequency as 1 when the word is occurred once")
    public void testOneFrequency() {
        int expectedFrequency  = 1;
        String wordToSearch = "Word";
        String notebookEntry = "Word Words Wor word";

        int result = notebookService.getFrequency(wordToSearch, notebookEntry);

        assertEquals(expectedFrequency, result);
    }

    @Test
    @DisplayName("should return frequency as 3 when the word is occurred 3 times")
    public void testThreeFrequency() {
        int expectedFrequency  = 3;
        String wordToSearch = "Word";
        String notebookEntry = "Word Word Word word";

        int result = notebookService.getFrequency(wordToSearch, notebookEntry);

        assertEquals(expectedFrequency, result);
    }

    @Test
    @DisplayName("should return empty array when empty string is given")
    public void testEmptyWord() {
        List<String> expectedWords = new ArrayList<>();
        String wordToSearch = "";
        String notebookEntry = "120 on the needle";

        List<String> result = notebookService.getSimilarWords(wordToSearch, notebookEntry);

        assertEquals(expectedWords, result);
    }

    @Test
    @DisplayName("should not return a word if it exists in the lab notebook")
    public void testExactWord() {
        List<String> expectedWords = new ArrayList<>();
        String wordToSearch = "needle";
        String notebookEntry = "120 on the needle";

        List<String> result = notebookService.getSimilarWords(wordToSearch, notebookEntry);

        assertEquals(expectedWords, result);
    }

    @Test
    @DisplayName("should return similar words")
    public void testSimilarWordsCase1() {
        List<String> expectedWords = new ArrayList<>(Arrays.asList("Words", "Wor", "word"));
        String wordToSearch = "Word";
        String notebookEntry = "Word Words Wor word";

        List<String> result = notebookService.getSimilarWords(wordToSearch, notebookEntry);

        assertEquals(expectedWords, result);
    }

    @Test
    @DisplayName("should return similar words")
    public void testSimilarWordsCase2() {
        List<String> expectedWords = new ArrayList<>(Collections.singletonList("word"));
        String wordToSearch = "Word";
        String notebookEntry = "Word Word Word word";

        List<String> result = notebookService.getSimilarWords(wordToSearch, notebookEntry);

        assertEquals(expectedWords, result);
    }
}