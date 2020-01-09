package org.azamat.repository;

import org.azamat.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
