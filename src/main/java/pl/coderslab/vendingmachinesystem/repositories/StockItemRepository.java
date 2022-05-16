package pl.coderslab.vendingmachinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vendingmachinesystem.entities.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Integer> {
}