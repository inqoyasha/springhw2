package org.azamat.service;

import org.azamat.model.Buyer;
import org.azamat.projections.buyer.BuyerAddress;
import org.azamat.projections.buyer.BuyerNameDiscountAddress;
import org.azamat.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }
    public void removeById(int id) {
        buyerRepository.deleteById(id);
    }
    public void add(Buyer buyer) {
        buyerRepository.save(buyer);
    }
    public Buyer findById(int id) {
        Optional<Buyer> optional = buyerRepository.findById(id);
        return optional.orElse(new Buyer());
    }
    public List<Buyer> updateById(int id, int sale) {
        List<Buyer> list = buyerRepository.findAll();
        for (Buyer buyer: list) {
            if (id == buyer.getBuyer_id()) {
                buyer.setDiscount(sale);
            }
        }

        return list;
    }
    public List<Buyer> fullUpdateById(int id, Buyer buyer) {
        List<Buyer> list = buyerRepository.findAll();
        for (Buyer b: list) {
            if (id == b.getBuyer_id()) {
                b.setBuyer_id(id);
                b.setLastName(buyer.getLastName());
                b.setBuyerAddress(buyer.getBuyerAddress());
                b.setDiscount(buyer.getDiscount());
            }
        }

        return list;
    }

    public List<BuyerAddress> findAllBuyerAddress() {
        return buyerRepository.findAllBuyerAddress();
    }
    public List<BuyerNameDiscountAddress> findLastNameAmdDiscountByAddress(){
        return buyerRepository.findLastNameAmdDiscountByAddress();
    }

    public List<BuyerNameDiscountAddress> findLastNameAndDiscountByAddressLike (String address) {
        return buyerRepository.findLastNameAndDiscountByBuyerAddressLike(address);
    }
}
