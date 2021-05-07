package ru.savelchev.counterwords.service.interfaces;

import java.util.TreeMap;

public interface CounterService {
    TreeMap<String, Integer> countWords(String[] words);
}
