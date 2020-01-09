package org.azamat.service;

import org.azamat.model.Buyer;
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
        Buyer b = list.get(id);
        b.setSale(sale);
        list.set(id,b);

        return list;
    }
    public List<Buyer> fullUpdateById(int id, Buyer buyer) {
        List<Buyer> list = buyerRepository.findAll();
        list.remove(id);
        list.add(id, buyer);

        return list;
    }
}
