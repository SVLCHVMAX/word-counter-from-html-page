package ru.savelchev.counterwords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savelchev.counterwords.service.interfaces.CounterService;
import ru.savelchev.counterwords.service.interfaces.DownloadService;
import ru.savelchev.counterwords.service.interfaces.ParseService;
import ru.savelchev.counterwords.service.interfaces.WordService;
import ru.savelchev.counterwords.utils.Printer;
import java.io.File;
import java.util.TreeMap;

@Service
public class Application {

    private final DownloadService downloadService;
    private final ParseService parseService;
    private final CounterService counterService;
    private final WordService wordService;
    private final Printer printer;

    @Autowired
    public Application(DownloadService downloadService, ParseService parseService, CounterService counterService, WordService wordService, Printer printer) {
        this.downloadService = downloadService;
        this.parseService = parseService;
        this.counterService = counterService;
        this.wordService = wordService;
        this.printer = printer;
    }

    public void getSolution(String url) {
        File downloadFile = downloadService.downloadHtml(url);
        String[] words = parseService.parseFile(downloadFile);
        TreeMap<String, Integer> wordCount = counterService.countWords(words);
        printer.printResult(wordCount);
        wordService.saveInDB(wordCount, url);
        System.out.println("Word statistics saved to database words to table word");
    }
}
