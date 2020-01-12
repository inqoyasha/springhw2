package org.azamat.repository;

import org.azamat.model.Purchase;
import org.azamat.projections.purchase.PurchaseBuyerNameShopName;
import org.azamat.projections.purchase.PurchaseMonth;
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
}
