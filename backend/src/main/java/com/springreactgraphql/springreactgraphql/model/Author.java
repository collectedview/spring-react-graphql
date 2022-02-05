package com.springreactgraphql.springreactgraphql.model;

import javax.persistence.*;
@Entity // This tells Hibernate to make a table out of this class
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Author() {
    }
    public Author(Integer id) {
        this.id = id;
    }
    public Author(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}