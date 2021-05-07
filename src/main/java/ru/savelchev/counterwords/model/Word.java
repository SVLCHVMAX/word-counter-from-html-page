package ru.savelchev.counterwords.model;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "word")
    private String word;

    @Column(name = "count")
    private int count;

    @Column(name = "url")
    private String url;

    public Word() {
    }

    public Word(String word, int count, String url) {
        this.word = word;
        this.count = count;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", count=" + count +
                ", url='" + url + '\'' +
                '}';
    }
}
