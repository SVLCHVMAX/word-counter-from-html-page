package ru.savelchev.counterwords.utils;

import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.TreeMap;

@Component
public class Printer {

    public void printResult(TreeMap<String, Integer> result) {
        if (result!=null) {
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        else {
            System.err.println("Some error occurred. Please check url address of the web-page and try again.");
        }
    }
}
