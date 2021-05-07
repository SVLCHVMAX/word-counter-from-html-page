package ru.savelchev.counterwords.service.interfaces;

import java.util.TreeMap;

public interface WordService {
    void saveInDB(TreeMap<String,Integer> result, String url);
}
