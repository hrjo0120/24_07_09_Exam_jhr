package org.koreait;

import java.time.LocalDateTime;

public class Motivation {
    int id;     //번호
    LocalDateTime regDate;     //날짜
    String content;  //명언
    String author;  //작가

    public Motivation(int id, LocalDateTime regDate, String content, String author) {
        this.id = id;
        this.regDate = regDate;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}