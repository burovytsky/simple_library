package com.burovytsky.simple_library.model;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private boolean has_user;
    @ManyToOne
    private User user;

    public Book(){}

    public Book(int id, String title, boolean has_user) {
        this.id = id;
        this.title = title;
        this.has_user = has_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHas_user() {
        return has_user;
    }

    public void setHas_user(boolean is_free) {
        this.has_user = is_free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                has_user == book.has_user &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, has_user);
    }
}
