package com.quocnguyen.entity;

import javax.persistence.*;

@Entity(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int mark;
    private String author;
    private String feedBack;

    public Comment(int mark, String author, String feedBack) {
        this.mark = mark;
        this.author = author;
        this.feedBack = feedBack;
    }

    public Comment(int id, int mark, String author, String feedBack) {
        this.id = id;
        this.mark = mark;
        this.author = author;
        this.feedBack = feedBack;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
