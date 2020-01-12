package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
@SecondaryTable(name="purchase",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "book", referencedColumnName="book_id"))
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;
    @Column(name = "bookname")
    private String bookName;
    private double cost;
    private String storage;
    private int quantity;

    public Book() {
    }

    public Book(String bookName, double cost, String storage, int quantity) {
        this.bookName = bookName;
        this.cost = cost;
        this.storage = storage;
        this.quantity = quantity;
    }

    public Book(String bookName, double cost) {
        this.bookName = bookName;
        this.cost = cost;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", bookName='" + bookName + '\'' +
                ", cost=" + cost +
                ", storage='" + storage + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
