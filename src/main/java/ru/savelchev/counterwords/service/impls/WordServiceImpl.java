package ru.savelchev.counterwords.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savelchev.counterwords.model.Word;
import ru.savelchev.counterwords.repository.WordRepository;
import ru.savelchev.counterwords.service.interfaces.WordService;
import java.util.Map;
import java.util.TreeMap;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public void saveInDB(TreeMap<String,Integer> result, String url) {
        for(Map.Entry<String,Integer> entry: result.entrySet()) {
            Word word = new Word(entry.getKey(), entry.getValue(),url);
            wordRepository.save(word);
        }
    }
}
