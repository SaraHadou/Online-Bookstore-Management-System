package com.bookstore.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "AVAILABLE")
    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "BORROWER_ID")
    private User borrower;

    public Book(String name, String author, String category, double price) {
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getBorrower() {
        return borrower;
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
