package org.azamat.repository;

import org.azamat.model.Purchase;
import org.azamat.projections.multiplytables.PurchaseIdLastNameDate;
import org.azamat.projections.multiplytables.PurchaseLastNameAddressDateByAddress;
import org.azamat.projections.multiplytables.PurchaseShopNameLastNameDiscountByAddressAndDiscount;
import org.azamat.projections.multiplytables.PurchaseStorageNameAddressQuantityCostByQuantityStorage;
import org.azamat.projections.purchase.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface
PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "SELECT date_part('month', p.selldate) as month FROM purchase as p", nativeQuery = true)
    List<PurchaseMonth> findAllPurchaseByMonth();
    @Query(value = "SELECT lastname, shopname \n" +
            "\tFROM purchase p JOIN shop s ON s.shop_id = p.shop \n" +
            "\tJOIN buyer b ON b.buyer_id = p.buyer\n" +
            "\tWHERE order_id = 3", nativeQuery = true)
    List<PurchaseBuyerNameShopName> findLastNameAndShopName();
    @Query(value = "select selldate, lastname, discount, bookname, p.quantity \n" +
            "\tfrom purchase p join book b on p.book = b.book_id \n" +
            "\tjoin buyer bu on p.buyer = bu.buyer_id\n" +
            "\twhere buyer = 2;", nativeQuery = true)
    List<PurchaseDateLastNameDiscountBookNameQuantity> findDateLastNameDiscountBookNameQuantity();
    @Query(value = "select order_id, lastname, selldate from purchase p join buyer b on p.buyer = b.buyer_id \n" +
            "\twhere sum >= 1201", nativeQuery = true)
    List<PurchaseIdLastNameDate> findIdLastNameDateBySum();
    @Query(value = "select lastname, b.address , selldate from purchase p join buyer b on p.buyer = b.buyer_id \n" +
            "\tjoin shop s on p.shop = s.shop_id \n" +
            "\twhere date_part('month', p.selldate) <= 3 and b.address = s.address", nativeQuery = true)
    List<PurchaseLastNameAddressDateByAddress> findLastNameAddressDateByAddress();
    @Query(value = "select shopname, lastname, discount \n" +
            "\tfrom purchase p join buyer b on p.buyer = b.buyer_id \n" +
            "\t\t\tjoin shop s on p.shop = s.shop_id \n" +
            "\twhere s.address != 'sarov' and discount between 10 and 15" +
            "order by lastname", nativeQuery = true)
    List<PurchaseShopNameLastNameDiscountByAddressAndDiscount> findShopNameByAddressAndDiscount();
    @Query(value = "select b.storage, b.quantity, s.address, cost   \n" +
            "\tfrom purchase p join buyer bu on p.buyer = bu.buyer_id \n" +
            "\t\t\tjoin shop s on p.shop = s.shop_id \n" +
            "\t\t\tjoin book b on p.book = b.book_id\n" +
            "\t\t\twhere b.quantity > 30 and s.address = bu.address\n" +
            "\t\t\torder by sum\n" +
            "\t", nativeQuery = true)
    List<PurchaseStorageNameAddressQuantityCostByQuantityStorage> findStorageNameByQuantity();

}
