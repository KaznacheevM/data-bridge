package com.example.test.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @ManyToOne(targetEntity = Author.class, optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    private Author author;

    public Book() {
    }

    public Book(String title, BigDecimal price, LocalDate creationDate, Author author) {
        this.title = title;
        this.price = price;
        this.creationDate = creationDate;
        this.author = author;
    }

    public Book(String title, BigDecimal price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(price, book.price) && Objects.equals(creationDate, book.creationDate) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, creationDate, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", author=" + author +
                '}';
    }
}
