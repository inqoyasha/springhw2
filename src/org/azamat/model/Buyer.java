package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
@SecondaryTable(name="purchase",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "buyer", referencedColumnName="buyer_id"))
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyer_id;
    @Column(name = "lastname")
    private String lastName;
    private String buyerAddress;
    private int discount;

    public Buyer() {
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyer_id=" + buyer_id +
                ", lastName='" + lastName + '\'' +
                ", address='" + buyerAddress + '\'' +
                ", sale=" + discount +
                '}';
    }
}
