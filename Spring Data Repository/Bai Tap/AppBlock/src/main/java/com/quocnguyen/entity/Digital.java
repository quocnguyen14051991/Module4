package com.quocnguyen.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "digital_blog")
public class Digital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDigital;
    private String title;
    private String description;
    private String image;
    private String author;
    private String timePost;
    private String shortDes;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
    private Category category;

    public Digital(Integer idDigital, String title, String description, String image, String author, String timePost, String shortDes) {
        this.idDigital = idDigital;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    public Digital() {
    }

    public Integer getIdDigital() {
        return idDigital;
    }

    public void setIdDigital(Integer idDigital) {
        this.idDigital = idDigital;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
