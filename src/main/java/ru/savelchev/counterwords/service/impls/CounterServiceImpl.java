package ru.savelchev.counterwords.service.impls;

import org.springframework.stereotype.Service;
import ru.savelchev.counterwords.service.interfaces.CounterService;
import java.util.TreeMap;

@Service
public class CounterServiceImpl implements CounterService {

    public TreeMap<String, Integer> countWords(String[] words) {
        if (words!=null) {
            TreeMap<String, Integer> result = new TreeMap<>();
            for (String word : words) {
                if (word != null) {
                    result.put(word.toUpperCase(), result.get(word.toUpperCase()) != null ? result.get(word.toUpperCase()) + 1 : 1);
                }
            }
            return result;
        }
        return null;

    }
}
