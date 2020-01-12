package org.azamat.repository;

import org.azamat.model.Buyer;
import org.azamat.projections.buyer.BuyerAddress;
import org.azamat.projections.buyer.BuyerNameDiscountAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    @Query(value = "SELECT b.address as address FROM buyer as b", nativeQuery = true)
    List<BuyerAddress> findAllBuyerAddress();

    @Query(value = "SELECT b.lastname as lastname, b.discount as discount FROM buyer as b WHERE address LIKE('dzerzhinsk')", nativeQuery = true)
    List<BuyerNameDiscountAddress> findLastNameAmdDiscountByAddress();

    List<BuyerNameDiscountAddress> findLastNameAndDiscountByBuyerAddressLike(String address);
}