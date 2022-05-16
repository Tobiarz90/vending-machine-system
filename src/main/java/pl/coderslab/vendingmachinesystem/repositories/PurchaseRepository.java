package pl.coderslab.vendingmachinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vendingmachinesystem.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}