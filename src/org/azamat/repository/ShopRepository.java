package org.azamat.repository;

import org.azamat.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
