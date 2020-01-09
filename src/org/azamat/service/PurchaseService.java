package org.azamat.service;

import org.azamat.model.Purchase;
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
    public List<Purchase> updateById(int id, int quantity) {
        List<Purchase> list = purchaseRepository.findAll();
        Purchase b = list.get(id);
        b.setQuantity(quantity);
        list.set(id,b);

        return list;
    }
    public List<Purchase> fullUpdateById(int id, Purchase purchase) {
        List<Purchase> list = purchaseRepository.findAll();
        list.remove(id);
        list.add(id, purchase);

        return list;
    }
}
