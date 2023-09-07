package com.bookstore.models;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "book_id_sequence", sequenceName = "book_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence")
    private int id;

    @Column(name = "Book Name")
    private String name;

    @Column(name = "Author")
    private String author;

    @Column(name = "Category")
    private String category;

    @Column(name = "Price($)")
    private double price;

    public Book(int id, String name, String author, String category, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.price = price;
    }
    public Book() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
