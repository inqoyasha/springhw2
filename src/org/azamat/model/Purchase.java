package org.azamat.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "purchase")
//@SecondaryTables({
//        @SecondaryTable(name="buyer",
//                pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName="buyer_id")
//        ),
//        @SecondaryTable(name="book",
//                pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName="book_id")
//        ),
//        @SecondaryTable(name="shop",
//                pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName="shop_id")
//        )}
//)
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    @Column(name = "selldate")
    private Date sellDate;
//    @Column(table = "shop"/*, name = "shop_id"*/)
    private int shop;
//    @Column(table = "buyer"/*, name = "buyer_id"*/)
    private int buyer;
//    @Column(table = "book"/*, name = "book_id"*/)
    private int book;

    private int quantity;
    private double sum;

    public Purchase() {
    }

    public Purchase(int order_id, Date sellDate, Shop shop, Buyer buyer, Book book, int quantity, double sum) {
        this.order_id = order_id;
        this.sellDate = sellDate;
        this.shop = shop.getShop_id();
        this.buyer = buyer.getBuyer_id();
        this.book = book.getBook_id();
        this.quantity = quantity;
        this.sum = sum;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "order_id=" + order_id +
                ", sellDate=" + sellDate +
                ", seller=" + shop +
                ", buyer=" + buyer +
                ", book=" + book +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }
}
