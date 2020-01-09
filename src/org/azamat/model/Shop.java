package org.azamat.model;

import javax.persistence.*;

@Entity
@Table(name = "shop")
@SecondaryTable(name="purchase",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "shop", referencedColumnName="shop_id"))
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shop_id;
    @Column(name = "shopname")
    private String shopName;
    private String address;
    private int commission;

    public Shop() {
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                ", commission=" + commission +
                '}';
    }
}
