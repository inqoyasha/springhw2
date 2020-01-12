package org.azamat.service;

import org.azamat.model.Purchase;
import org.azamat.projections.multiplytables.PurchaseIdLastNameDate;
import org.azamat.projections.multiplytables.PurchaseLastNameAddressDateByAddress;
import org.azamat.projections.multiplytables.PurchaseShopNameLastNameDiscountByAddressAndDiscount;
import org.azamat.projections.multiplytables.PurchaseStorageNameAddressQuantityCostByQuantityStorage;
import org.azamat.projections.purchase.*;
import org.azamat.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
    public void removeById(int id) {
        purchaseRepository.deleteById(id);
    }
    public void add(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
    public Purchase findById(int id) {
        Optional<Purchase> optional = purchaseRepository.findById(id);
        return optional.orElse(new Purchase());
    }
    public List<Purchase> updateById(int id, int quantity, double sum) {
        List<Purchase> list = purchaseRepository.findAll();
        for (Purchase p: list) {
            if (id == p.getOrder_id()) {
                p.setQuantity(quantity);
                p.setSum(sum);
            }
        }

        return list;
    }
    public List<Purchase> fullUpdateById(int id, Purchase purchase) {
        List<Purchase> list = purchaseRepository.findAll();
        for (Purchase p: list) {
            if (id == p.getOrder_id()) {
                p.setOrder_id(id);
                p.setQuantity(purchase.getQuantity());
                p.setShop(purchase.getShop());
                p.setBuyer(purchase.getBuyer());
                p.setBook(purchase.getBook());
                p.setSellDate(purchase.getSellDate());
                p.setSum(purchase.getSum());
            }
        }

        return list;
    }

    public List<PurchaseMonth> findAllPurchaseByMonth() {
        return purchaseRepository.findAllPurchaseByMonth();
    }

    public List<PurchaseBuyerNameShopName> findLastNameAndShopName() {
        return purchaseRepository.findLastNameAndShopName();
    }
    public List<PurchaseDateLastNameDiscountBookNameQuantity> findDateLastNameDiscountBookNameQuantity() {
        return purchaseRepository.findDateLastNameDiscountBookNameQuantity();
    }
    public List<PurchaseIdLastNameDate> findIdLastNameDateBySum() {
        return purchaseRepository.findIdLastNameDateBySum();
    }
    public List<PurchaseLastNameAddressDateByAddress> findLastNameAddressDateByAddress() {
        return purchaseRepository.findLastNameAddressDateByAddress();
    }
    public List<PurchaseShopNameLastNameDiscountByAddressAndDiscount> findShopNameByAddressAndDiscount() {
        return purchaseRepository.findShopNameByAddressAndDiscount();
    }
    public List<PurchaseStorageNameAddressQuantityCostByQuantityStorage> findStorageNameByQuantity() {
        return purchaseRepository.findStorageNameByQuantity();
    }
}
