package org.azamat.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "purchase")
/*@SecondaryTables({
        @SecondaryTable(name="buyer",
                pkJoinColumns = @PrimaryKeyJoinColumn(name="buyer", referencedColumnName="buyer_id")
        ),
        @SecondaryTable(name="book",
                pkJoinColumns = @PrimaryKeyJoinColumn(name="book", referencedColumnName="book_id")
        ),
        @SecondaryTable(name="shop",
                pkJoinColumns = @PrimaryKeyJoinColumn(name="seller", referencedColumnName="shop_id")
        )}
)*/
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private Calendar sellDate;

//    private Shop seller;
//    private Buyer buyer;
//    private Book book;
//    @Column(table = "shop")
    private int seller;
//    @Column(table = "buyer")
    private int buyer;
//    @Column(table = "book")
    private int book;

    private int quantity;
    private double sum;

    public Purchase() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Calendar getSellDate() {
        return sellDate;
    }

    public void setSellDate(Calendar sellDate) {
        this.sellDate = sellDate;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
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
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", book=" + book +
                ", quantity=" + quantity +
                ", sum=" + sum +
                '}';
    }
}
