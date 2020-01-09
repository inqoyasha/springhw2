package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyer_id;
    private String lastName;
    private String address;
    private int sale;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyer_id=" + buyer_id +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", sale=" + sale +
                '}';
    }
}
