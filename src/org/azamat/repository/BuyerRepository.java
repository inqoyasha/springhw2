package org.azamat.repository;

import org.azamat.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
}
