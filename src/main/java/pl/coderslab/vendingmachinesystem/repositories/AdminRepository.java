package pl.coderslab.vendingmachinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vendingmachinesystem.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);

}