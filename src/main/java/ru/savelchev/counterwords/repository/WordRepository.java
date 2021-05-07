package ru.savelchev.counterwords.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savelchev.counterwords.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word,Integer> {

}
