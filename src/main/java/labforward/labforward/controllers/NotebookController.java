package labforward.labforward.controllers;

import labforward.labforward.Services.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/notebook")
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    @RequestMapping("/frequency")
    public int getFrequency(
            @RequestParam("searchQuery") String searchQuery,
            @RequestParam("notebookEntry") String notebookEntry
    ) {
        return notebookService.getFrequency(searchQuery, notebookEntry);
    }

    @RequestMapping("/similar")
    public List<String> getSimilarWords(
            @RequestParam("searchQuery") String searchQuery,
            @RequestParam("notebookEntry") String notebookEntry
    ) {
        return notebookService.getSimilarWords(searchQuery, notebookEntry);
    }
}
