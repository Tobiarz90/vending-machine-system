package pl.coderslab.vendingmachinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vendingmachinesystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}