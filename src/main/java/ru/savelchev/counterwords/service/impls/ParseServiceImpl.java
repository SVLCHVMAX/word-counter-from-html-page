package ru.savelchev.counterwords.service.impls;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.savelchev.counterwords.service.interfaces.ParseService;
import java.io.File;
import java.io.IOException;

@Service
public class ParseServiceImpl implements ParseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParseServiceImpl.class);

    public String[] parseFile(File file) {
        try {
            String text = Jsoup.parse(file, "UTF-8").body().text();
            String separators = "[\\s,.!?'\";:«»©\\[\\]()\n\r\t<>0-9=/\\\\@#&+{}%±~_$*^|–—‑-]+";
            return text.split(separators);
        } catch (IOException e) {
            System.err.println("Some error occurred. Please try again.");
            LOGGER.error("Exception: " + e);
            System.exit(1);
        }
        return null;
    }
}
