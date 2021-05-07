package ru.savelchev.counterwords.service.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savelchev.counterwords.service.interfaces.DownloadService;
import ru.savelchev.counterwords.utils.FileName;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class DownloadServiceImpl implements DownloadService {

    private final FileName fileName;
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadServiceImpl.class);

    @Autowired
    public DownloadServiceImpl(FileName fileName) {
        this.fileName = fileName;
    }

    public File downloadHtml(String htmlUrl) {
        try {
            URL url = new URL(htmlUrl);
            File dir = new File("downloads");
            dir.mkdir();
            File downloadFile = new File(dir,fileName.getFileName());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(downloadFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                }
            }
            return downloadFile;
        } catch (MalformedURLException e) {
            System.err.println("Please check url address of the web-page.");
            LOGGER.error("URl - {}, " + e, htmlUrl);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Please check url address of the web-page. Error saving to file.");
            LOGGER.error("URl - {}, " + e, htmlUrl);
            System.exit(1);
        }
        return null;
    }
}
