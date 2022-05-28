package pl.coderslab.vendingmachinesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.vendingmachinesystem.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}