package com.quocnguyen.entity;

import javax.persistence.*;

@Entity(name = "digital_blog")
public class DigitalEntity extends BaseEntity {
    private String title;
    private String description;
    private String image;
    private String author;
    private String shortDes;
    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private CategoryEntity category;

    public DigitalEntity() {
    }

    public DigitalEntity(String title, String description, String image, String author, String shortDes, CategoryEntity category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.shortDes = shortDes;
        this.category = category;
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

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
