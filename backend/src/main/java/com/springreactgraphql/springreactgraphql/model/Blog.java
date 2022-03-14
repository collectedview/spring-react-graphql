package com.springreactgraphql.springreactgraphql.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "blog")
public class Blog implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @Column(unique=true)
    private Integer views;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;

    public Blog(Long id, String title, String description, Integer views, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.views = views;
        this.author = author;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Blog[id=" + id + ", title=" + title + ", description=" + description + ", views=" + views + ", author=" + author + "]";
    }

}