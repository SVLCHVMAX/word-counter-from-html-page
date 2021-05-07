package ru.savelchev.counterwords.service.interfaces;

import java.io.File;

public interface DownloadService {
    File downloadHtml(String htmlUrl);
}
