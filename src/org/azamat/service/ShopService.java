package org.azamat.service;

import org.azamat.model.Shop;
import org.azamat.projections.shop.ShopNameAddress;
import org.azamat.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
    public void removeById(int id) {
        shopRepository.deleteById(id);
    }
    public void add(Shop shop) {
        shopRepository.save(shop);
    }
    public Shop findById(int id) {
        Optional<Shop> optional = shopRepository.findById(id);
        return optional.orElse(new Shop());
    }
    public List<Shop> updateById(int id, String name, int commission) {
        List<Shop> list = shopRepository.findAll();
        for (Shop s: list) {
            if (id == s.getShop_id()) {
                s.setShopName(name);
                s.setCommission(commission);
            }
        }

        return list;
    }
    public List<Shop> fullUpdateById(int id, Shop shop) {
        List<Shop> list = shopRepository.findAll();
        for (Shop s: list) {
            if (id == s.getShop_id()) {
                    s.setShop_id(id);
                    s.setShopName(shop.getShopName());
                    s.setAddress(shop.getAddress());
                    s.setCommission(shop.getCommission());
                }
            }

        return list;
    }
    public List<ShopNameAddress> findShopNameByAddressStartsWith(String address) {
        return shopRepository.findShopNameByAddressStartsWith(address);
    }
}
